package ridesharing.domain.operation.vehicle

import ridesharing.domain.traffic.Location

case class Vehicle(
  currentLocation:      Location,
  state:                State,
  seatCount:            Int,
  speedMeterPerSeconds: Int,
  schedules:            List[Long] = Nil,
  id:                   Option[Long] = None
) {

  def isActive: Boolean = state match {
    case _ @(Active | OnOperation) => true
    case _ => false
  }
}
