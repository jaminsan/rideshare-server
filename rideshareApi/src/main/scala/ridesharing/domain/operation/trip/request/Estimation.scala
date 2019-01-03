package ridesharing.domain.operation.trip.request

import ridesharing.domain.operation.Duration

// 運賃事前確定の場合は見積もりが請求を持つ
case class Estimation(
  pickUpAt:        Duration,
  dropOffAt:       Duration,
  durationSeconds: Int,
  distanceMeter:   Double
)
