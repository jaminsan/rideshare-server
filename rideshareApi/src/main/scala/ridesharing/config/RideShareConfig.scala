package ridesharing.config

import cats.effect.Sync
import pureconfig.generic.auto._
import pureconfig.module.catseffect._

final case class ServerConfig(host: String, port: Int)

final case class RideShareConfig(server: ServerConfig)

object RideShareConfig {

  def load[F[_]](implicit E: Sync[F]): F[RideShareConfig] = loadConfigF[F, RideShareConfig]("rideshare")
}
