package ridesharing.domain.vehicle

import ridesharing.domain.traffic.Location
import ridesharing.domain.vehicle.trip.Trip

case class Vehicle(
  currentLocation:      Location,
  state:                State,
  seatCount:            Int,
  speedMeterPerSeconds: Int,
  trips:                List[Trip] = Nil,
  id:                   Option[Long] = None
) {

  def isActive: Boolean = state match {
    case _ @(Active | OnOperation) => true
    case _ => false
  }
}
