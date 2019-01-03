package ridesharing.adapter.external.http4s

import cats.effect._
import cats.implicits._
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.server.{Router, Server => H4Server}
import ridesharing.adapter.endpoint.controllers.auth.passenger.AccountEndpoints
import ridesharing.adapter.endpoint.controllers.passenger.landmark.LandmarkEndpoints
import ridesharing.adapter.repository.inmemory.{AccountRepositoryInMemory, LandmarkRepositoryInMemory}
import ridesharing.config.RideShareConfig

import scala.language.higherKinds

object Server extends IOApp {

  def createServer[F[_]: ContextShift: ConcurrentEffect: Timer]: Resource[F, H4Server[F]] =
    for {
      conf <- Resource.liftF(RideShareConfig.load[F])
      landmarkRepo    = LandmarkRepositoryInMemory[F]()
      accountRepo     = AccountRepositoryInMemory[F]()
      passengerRoutes = LandmarkEndpoints.endpoints[F](landmarkRepo)
      authRoutes      = AccountEndpoints.endpoints[F](accountRepo)
      httpApp         = Router("/auth" -> authRoutes, "/passenger" -> passengerRoutes).orNotFound
      server <- BlazeServerBuilder[F]
        .bindHttp(conf.server.port, conf.server.host)
        .withHttpApp(httpApp)
        .resource
    } yield server

  def run(args: List[String]): IO[ExitCode] = createServer.use(_ => IO.never).as(ExitCode.Success)
}
