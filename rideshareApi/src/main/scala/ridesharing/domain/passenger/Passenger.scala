package ridesharing.domain.passenger

case class Passenger(
  name:  String,
  age:   Int,
  phone: String,
  id:    Option[Long] = None
)
