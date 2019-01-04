package ridesharing.domain.operation

import java.time.OffsetDateTime

// schedule と scheduleDone が1対多になるケースがあるかどうか
// schedule と scheduleDone の紐付け
sealed trait ScheduleDone {
  val timestamp: OffsetDateTime
  val scheduleId: Long
}

case class VehicleArrivedPickUpLocation(timestamp: OffsetDateTime, scheduleId: Long) extends ScheduleDone

case class TripQualificationConfirmed(timestamp: OffsetDateTime, scheduleId: Long)  extends ScheduleDone

case class PassengerOnTrip(timestamp: OffsetDateTime, scheduleId: Long)  extends ScheduleDone

case class PassengerCompleteTrip(timestamp: OffsetDateTime, scheduleId: Long, receiptId: Long)  extends ScheduleDone
