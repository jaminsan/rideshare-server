package ridesharing.domain.operation.trip.changeRequest

sealed trait Request

case class Cancel(tripId: Long) extends Request

//case class ChangeSeatCount(tripId: Long, seatCount: Int) extends Request
