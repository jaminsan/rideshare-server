package ridesharing.adapter.endpoint.controllers.passenger.landmark

import cats.effect.Effect
import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import ridesharing.adapter.external.http4s.QueryParameterMatchers
import ridesharing.domain.passenger.landmark.{Landmark, LandmarkRepository}

import scala.language.higherKinds

class LandmarkEndpoints[F[_]: Effect] extends Http4sDsl[F] with QueryParameterMatchers {

  import cats.implicits._

  implicit val landmarkDecoder: EntityDecoder[F, Landmark] = jsonOf[F, Landmark]

  private def crateLandmarkEndpoint(landmarkRepository: LandmarkRepository[F]): HttpRoutes[F] =
    HttpRoutes.of[F] {
      case req @ POST -> Root / "landmarks" =>
        for {
          landmark <- req.as[Landmark]
          created  <- landmarkRepository.store(landmark)
          resp     <- Created(created.asJson)
        } yield resp
    }

  private def listLandmarkEndpoint(landmarkRepository: LandmarkRepository[F]): HttpRoutes[F] =
    HttpRoutes.of[F] {
      case GET -> Root / "landmarks" :? PassengerIdQueryParamMatcher(passengerId) =>
        for {
          landmarks <- landmarkRepository.findListByPassengerId(passengerId)
          resp      <- Ok(landmarks.asJson)
        } yield resp
    }

  private def updateLandmarkEndpoint(landmarkRepository: LandmarkRepository[F]): HttpRoutes[F] =
    HttpRoutes.of[F] {
      case req @ PUT -> Root / "landmarks" / LongVar(landmarkId) =>
        for {
          landmark <- req.as[Landmark]
          updated  = landmark.copy(id = landmarkId.some)
          _        <- landmarkRepository.store(landmark)
          resp     <- Ok(updated.asJson)
        } yield resp
    }

  def endpoints(landmarkRepository: LandmarkRepository[F]): HttpRoutes[F] =
    crateLandmarkEndpoint(landmarkRepository) <+> listLandmarkEndpoint(landmarkRepository) <+> updateLandmarkEndpoint(landmarkRepository)
}

object LandmarkEndpoints {

  def endpoints[F[_]: Effect](landmarkRepository: LandmarkRepository[F]): HttpRoutes[F] =
    new LandmarkEndpoints[F].endpoints(landmarkRepository)
}
