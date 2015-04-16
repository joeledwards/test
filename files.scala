val files = for (file <- (new java.io.File(".")).listFiles) yield file
for (file <- files) println(file)

