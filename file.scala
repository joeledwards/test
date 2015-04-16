import scala.io.Source

if (args.length < 1) {
  println("No file name supplied")
}
else {
  val fileName = args(0)
  Source.fromFile(fileName).getLines().foreach(println)
}
