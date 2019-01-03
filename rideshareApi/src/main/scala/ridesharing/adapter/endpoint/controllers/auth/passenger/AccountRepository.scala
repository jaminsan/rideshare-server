package ridesharing.adapter.endpoint.controllers.auth.passenger

import ridesharing.domain.passenger.Passenger

import scala.language.higherKinds

trait AccountRepository[F[_]] {

  def store(e: Account, p: Passenger): F[Passenger]

  def find(e: Account): F[Option[Passenger]]
}
