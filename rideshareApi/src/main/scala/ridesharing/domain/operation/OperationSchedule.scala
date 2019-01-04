package ridesharing.domain.operation

import ridesharing.domain.operation.trip.{Receipt, Trip}
import ridesharing.domain.operation.trip.request.Request
import ridesharing.domain.operation.vehicle.Vehicle

// 乗客の乗降やランデブー地点への到着などの車両単位で完結しそうなものもいちいち運行に問い合わせするべき（？）ロックが発生する
// 乗車人数変更や乗降時間変更は schedule 全体に関わるので問い合わせすべき
case class OperationSchedule(
  vehicles:  List[Vehicle],
  trips:     List[Trip],
  schedules: List[Schedule],
  id:        Option[Long]
) {

  def reschedule(requests: List[Request]): List[OperationSchedule] = ???

  def doneSchedule(scheduleId: Long): List[OperationSchedule] = ???

  def adjustFare(tripId: Long): Receipt = ???
}
