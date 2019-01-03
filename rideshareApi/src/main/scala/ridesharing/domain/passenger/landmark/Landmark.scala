package ridesharing.domain.passenger.landmark

import ridesharing.domain.traffic.Location

case class Landmark(
  passengerId: Long,
  name:        String,
  location:    Location,
  id:          Option[Long] = None
)
