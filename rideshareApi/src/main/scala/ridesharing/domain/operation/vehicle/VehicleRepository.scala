package ridesharing.domain.operation.vehicle

import scala.language.higherKinds

trait VehicleRepository[F[_]] { def findList(p: Vehicle => Boolean): F[List[Vehicle]] }
