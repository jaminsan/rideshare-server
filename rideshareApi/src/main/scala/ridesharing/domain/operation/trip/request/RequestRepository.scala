package ridesharing.domain.operation.trip.request

import scala.language.higherKinds

trait RequestRepository[F[_]] {

  def update(ls: List[Request]): F[Unit]
}
