package ridesharing.passenger

import ridesharing.TestBase

class Landmark extends TestBase {

  def feature =
    Feature("Landmark management") {

      Scenario("Passenger register Landmark") {
        When User post(s"$BaseUrl/auth/signUp").withBody("""
            |{
            | "account": {
            |   "phone": "00000000000",
            |   "password": "password"
            | },
            | "passenger": {
            |   "name": "name",
            |   "age": 30,
            |   "phone": "00000000000"
            | }
            |}
          """.stripMargin)
        show_last_response

        save_body_path("id" -> "passenger-id")

        When Passenger post(s"$BaseUrl/passenger/landmarks").withBody("""
            |{
            | "name": "ZOZOテクノロジーズ",
            | "passengerId": <passenger-id>,
            | "location": {
            |   "linkId": 1,
            |   "rate": 0.0,
            |   "latitude": 35.662669,
            |   "longitude": 139.708962
            | }
            |}
          """.stripMargin)
        show_last_response

        Then assert status.is(201)
        Then assert body.path("id").isPresent
        Then assert body.path("name").is("ZOZOテクノロジーズ")
        Then assert body.path("location.linkId").is(1)
        Then assert body.path("location.rate").is(0.0)
        Then assert body.path("location.latitude").is(35.662669)
        Then assert body.path("location.longitude").is(139.708962)
      }
    }
}
