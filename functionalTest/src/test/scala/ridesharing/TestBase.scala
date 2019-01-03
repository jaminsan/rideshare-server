package ridesharing

import com.github.agourlay.cornichon.CornichonFeature

import scala.language.postfixOps

trait TestBase extends CornichonFeature {

  import scala.concurrent.duration._
  override lazy val requestTimeout: FiniteDuration = 30 seconds

  val BaseUrl = "http://localhost:8080"

}
