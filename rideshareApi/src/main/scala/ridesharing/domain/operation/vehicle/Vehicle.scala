package ridesharing.domain.operation.vehicle

import ridesharing.domain.traffic.Location

case class Vehicle(
  currentLocation:      Location,
  state:                State,
  seatCount:            Int,
  speedMeterPerSeconds: Int,
  operation:            Option[Operation] = None,
  id:                   Option[Long] = None
) {

  def isActive: Boolean = state match {
    case _ @(Active | OnOperation) => true
    case _ => false
  }
}
