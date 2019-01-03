package ridesharing.auth

import ridesharing.TestBase

class Passenger extends TestBase {

  def feature =
    Feature("Passenger authentication") {

      Scenario("User signup for new passenger account") {
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
            |}""".stripMargin)
        show_last_response

        Then assert status.is(201)
        Then assert body.path("id").isPresent
        Then assert body.path("name").is("name")
        Then assert body.path("age").is(30)
        Then assert body.path("phone").is("00000000000")
      }

      Scenario("User login") {
        When User post(s"$BaseUrl/auth/login").withBody("""
            |{
            | "phone": "00000000000",
            | "password": "password"
            |}
          """.stripMargin)
        show_last_response

        Then assert status.is(200)
        Then assert headers.contain("X-Auth-Token" -> "token")
      }
    }

}
