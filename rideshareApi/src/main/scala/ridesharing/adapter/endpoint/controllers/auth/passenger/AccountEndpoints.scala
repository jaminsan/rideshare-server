package ridesharing.adapter.endpoint.controllers.auth.passenger

import cats.effect.Effect
import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import ridesharing.domain.passenger.Passenger

import scala.language.higherKinds

class AccountEndpoints[F[_]: Effect] extends Http4sDsl[F] {

  import cats.implicits._

  implicit val accountDecoder:      EntityDecoder[F, Account]       = jsonOf[F, Account]
  implicit val passengerDecoder:    EntityDecoder[F, Passenger]     = jsonOf[F, Passenger]
  implicit val signUpRequestDecode: EntityDecoder[F, SignUpRequest] = jsonOf[F, SignUpRequest]

  case class SignUpRequest(account: Account, passenger: Passenger)

  private def signUpEndpoint(accountRepository: AccountRepository[F]): HttpRoutes[F] =
    HttpRoutes.of[F] {
      case req @ POST -> Root / "signUp" =>
        for {
          signUp <- req.as[SignUpRequest]
          account   = signUp.account
          passenger = signUp.passenger
          created <- accountRepository.store(account, passenger)
          resp    <- Created(created.asJson)
        } yield resp
    }

  private def loginEndpoint(accountRepository: AccountRepository[F]): HttpRoutes[F] =
    HttpRoutes.of[F] {
      case req @ POST -> Root / "login" =>
        val action = for {
          login     <- req.as[Account]
          passenger <- accountRepository.find(login)
        } yield passenger

        action.flatMap {
          case Some(p) => Ok(p.asJson, Header("X-Auth-Token", "token"))
          case None => BadRequest(s"Login failed")
        }
    }

  def endpoints(accountRepository: AccountRepository[F]): HttpRoutes[F] =
    signUpEndpoint(accountRepository) <+> loginEndpoint(accountRepository)
}

object AccountEndpoints {

  def endpoints[F[_]: Effect](accountRepository: AccountRepository[F]): HttpRoutes[F] =
    new AccountEndpoints[F].endpoints(accountRepository)
}
