package ridesharing.domain.operation

import java.time.OffsetDateTime

// schedule と scheduleDone が1対多になるケースがあるかどうか
// schedule と scheduleDone の紐付け
sealed abstract class ScheduleDone(timestamp: OffsetDateTime, scheduleId: Long)

case class VehicleArrivedPickUpLocation(timestamp: OffsetDateTime, scheduleId: Long)

case class TripQualificationConfirmed(timestamp: OffsetDateTime, scheduleId: Long)

case class PassengerOnTrip(timestamp: OffsetDateTime, scheduleId: Long)

case class PassengerCompleteTrip(timestamp: OffsetDateTime, scheduleId: Long, receiptId: Long)
