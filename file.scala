import scala.io.Source

object File extends App {
  if (args.length < 1) {
    println("No file name supplied")
  }
  else {
    val fileName = args(0)
    Source.fromFile(fileName).getLines().foreach(println)
  }
}
