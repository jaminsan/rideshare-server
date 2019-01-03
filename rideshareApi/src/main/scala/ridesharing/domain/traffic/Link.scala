package ridesharing.domain.traffic

case class Link(
  id:            Option[Long],
  start:         Node,
  end:           Node,
  distanceMeter: Double
)
