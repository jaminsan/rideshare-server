package ridesharing.domain.operation.trip

// 乗合相手を知りたいとなった場合はどうするか
// これは本来運行に持つべきものの気がする（？）
// 請求は誰に聞くべきか Trip を受け取って receipt を返す
case class Trip(
  id:          Option[Long],
  passengerId: Long,
  schedules:   List[Long]
)
