package ridesharing.domain.operation.vehicle

case class Operation(
  operationScheduleId: Long,
  schedules:           List[Long]
)
