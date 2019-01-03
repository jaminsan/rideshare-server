package ridesharing.domain.vehicle

sealed trait State

case object Active extends State

case object InActive extends State

case object OnOperation extends State
