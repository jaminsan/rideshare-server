package ridesharing.domain.operation.trip

case class Receipt(
  baseFare:          Double,
  distanceFare:      Double,
  rideShareDiscount: Double,
  durationSeconds:   Int,
  distanceMeter:     Double,
  feePerMeter:       Double,
  id:                Option[Long] = None
) {

  lazy val total: Double = (baseFare + distanceFare) - rideShareDiscount
}
