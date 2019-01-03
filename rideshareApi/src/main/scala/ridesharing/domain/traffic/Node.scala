package ridesharing.domain.traffic

case class Node(
  id:       Option[Long],
  location: Location,
  in:       List[Link],
  out:      List[Link],
)
