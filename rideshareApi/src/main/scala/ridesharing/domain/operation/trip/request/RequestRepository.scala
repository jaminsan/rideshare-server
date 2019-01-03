package ridesharing.domain.operation.trip.request

import scala.language.higherKinds

trait RequestRepository[F[_]] {
  def findList(p: Request => Boolean): F[List[Request]]

  def update(ls: List[Request]): F[Unit]
}
