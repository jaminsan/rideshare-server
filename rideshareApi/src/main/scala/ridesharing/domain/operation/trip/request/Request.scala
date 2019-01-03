package ridesharing.domain.operation.trip.request

import ridesharing.domain.traffic.Location

sealed abstract class Request(
  passengerId: Long,
  pickUp:      Location,
  destination: Location,
  seatCount:   Int = 1,
  id:          Option[Long] = None)

case class InProgress(
  passengerId: Long,
  pickUp:      Location,
  destination: Location,
  seatCount:   Int = 1,
  id:          Option[Long] = None)
  extends Request(passengerId, pickUp, destination, seatCount, id) {

  def reject(reason: Reason): Request =
    Rejected(
      passengerId,
      pickUp,
      destination,
      seatCount,
      id,
      reason
    )

  def accept(estimation: Estimation, tripId: Long): Request =
    Accepted(
      passengerId,
      pickUp,
      destination,
      seatCount,
      id,
      estimation,
      tripId
    )

//　import ridesharing.domain.passenger.Passenger
//  implicit class OperationOps(passenger: Passenger) {
//
//    def accept(r: InProgress, estimation: Estimation, tripId: Long): Request =
//      r.accept(estimation, tripId)
//  }
}

case class Accepted(
  passengerId: Long,
  pickUp:      Location,
  destination: Location,
  seatCount:   Int,
  id:          Option[Long],
  estimation:  Estimation,
  tripId:      Long)
  extends Request(passengerId, pickUp, destination, seatCount, id)

case class Rejected(
  passengerId: Long,
  pickUp:      Location,
  destination: Location,
  seatCount:   Int,
  id:          Option[Long],
  reason:      Reason)
  extends Request(passengerId, pickUp, destination, seatCount, id)

sealed abstract class Reason(code: String)

case class TripOverlapped() extends Reason("trip_overlapped")

case class NoOperationVacancy() extends Reason("no_operation_vacancy")
