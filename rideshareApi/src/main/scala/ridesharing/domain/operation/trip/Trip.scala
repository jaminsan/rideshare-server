package ridesharing.domain.operation.trip

// TODO: schedules
case class Trip(
  id:          Option[Long],
  passengerId: Long,
  receipt:     Option[Receipt]
)
