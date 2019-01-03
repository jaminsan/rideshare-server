package ridesharing.domain.passenger

import scala.language.higherKinds

trait PassengerRepository[F[_]] {

  def store(e: Passenger): F[Passenger]

  def findById(id: Long): F[Passenger]
}
