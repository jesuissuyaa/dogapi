import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn

object Sample {
  def main(args: Array[String]) {
    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    // needed for flatMap & onComplete
    implicit val executionContext = system.dispatcher

    val route = 
      path("hello") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`,
          "<h1>Say helloto akka-http</h1>"))
        }
      }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress Return to stop...")
    StdIn.readLine() // runs until RETURN is pressed
    bindingFuture
      .flatMap(_.unbind()) // triggers unbinding from port
      .onComplete(_ => system.terminate()) // shutdown
  }
}