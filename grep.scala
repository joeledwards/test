
def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toList

def grep(pattern: String) =
  for (
    file <- (new java.io.File(".")).listFiles
    if file.getName.endsWith(".scala");
    line <- fileLines(file)
    if line.matches(pattern)
  ) println(file + ": " + line)

grep(".*line.*")

