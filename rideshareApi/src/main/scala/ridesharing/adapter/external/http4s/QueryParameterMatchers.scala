package ridesharing.adapter.external.http4s

import org.http4s.dsl.impl.QueryParamDecoderMatcher

trait QueryParameterMatchers {

  // TODO: 認証情報から passengerId を特定したい
  object PassengerIdQueryParamMatcher extends QueryParamDecoderMatcher[Long]("passengerId")
}
