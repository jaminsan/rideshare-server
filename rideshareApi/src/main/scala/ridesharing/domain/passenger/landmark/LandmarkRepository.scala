package ridesharing.domain.passenger.landmark

import scala.language.higherKinds

trait LandmarkRepository[F[_]] {

  def store(e: Landmark): F[Landmark]

  def findById(id: Long): F[Option[Landmark]]

  def findListByPassengerId(passengerId: Long): F[List[Landmark]]
}
