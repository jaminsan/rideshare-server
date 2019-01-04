package ridesharing.domain.operation

import ridesharing.domain.traffic.Location

sealed abstract class Schedule[A <: ScheduleDone](
  duration:  Duration,
  location:  Location,
  seatCount: Int,
  vehicleId: Long,
  tripId:    Long,
  done:      Option[A] = None,
  id:        Option[Long] = None)

case class PickingUp(
  location:  Location,
  duration:  Duration,
  seatCount: Int,
  vehicleId: Long,
  tripId:    Long,
  done:      Option[VehicleArrivedPickUpLocation],
  id:        Option[Long] = None)
  extends Schedule(duration, location, seatCount, vehicleId, tripId, done, id)

// これは今はいらなくて乗客が乗車完了するまでが PickingUp で良いかも
case class Rendezvous(
  location:  Location,
  duration:  Duration,
  seatCount: Int,
  vehicleId: Long,
  tripId:    Long,
  done:      Option[TripQualificationConfirmed] = None,
  id:        Option[Long] = None)
  extends Schedule(duration, location, seatCount, vehicleId, tripId, done, id)

// 乗合人数が増えると扉に近い人が一旦降りたりするので乗降にかかる時間が変わりそう
// 乗車人数が増えると乗降時間が増えそう
case class PickUp(
  location:  Location,
  duration:  Duration,
  seatCount: Int,
  vehicleId: Long,
  tripId:    Long,
  done:      Option[PassengerOnTrip] = None,
  id:        Option[Long] = None)
  extends Schedule(duration, location, seatCount, vehicleId, tripId, done, id)

case class DropOff(
  location:  Location,
  duration:  Duration,
  seatCount: Int,
  vehicleId: Long,
  tripId:    Long,
  done:      Option[PassengerCompleteTrip] = None,
  id:        Option[Long] = None)
  extends Schedule(duration, location, seatCount, vehicleId, tripId, done, id)
