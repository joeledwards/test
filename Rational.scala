
case class Rational(numerator: Long, denominator: Long) {
  require(denominator != 0)

  private val g = gcd(numerator.abs, denominator.abs)
  val n = numerator / g
  val d = denominator / g

  def this(n: Long) {
    this(n, 1)
  }

  def +(o: Rational) = Rational(n * o.d + o.n * d, d * o.d)
  def +(i: Long) = Rational(i * d + n, d)

  def -(o: Rational) = Rational(n * o.d - o.n * d, d * o.d)
  def -(i: Long) = Rational(i * d - n, d)

  def *(o: Rational) = Rational(n * o.n, d * o.d)
  def *(i: Long) = Rational(i * n, d)

  def /(o: Rational) = Rational(n * o.d, d * o.n)
  def /(i: Long) = Rational(n, i * d)

  def ==(o: Rational): Boolean = (n == o.n) && (d == o.d)

  override def toString = n + "/" + d

  private def gcd(a: Long, b: Long): Long =
    if (b == 0) a else gcd(b, a % b)
}

object Rational {
  implicit def longToRational(i: Long) = Rational(i, 1)

  def main(args: Array[String]): Unit = {
    println(Rational(1,7))
    println(Rational(1,7) + Rational(8,9))
    println(Rational(1,2) * Rational(1,2))
    println(Rational(2,4) / Rational(1,2))
    println(Rational(1,2) + Rational(1,4))
    println(Rational(2,3) - Rational(1,2))

    assert(Rational(1,1) == Rational(1,1))
    assert(Rational(1,2) * Rational(1,2) == Rational(1,4))
    assert(Rational(2,4) / Rational(1,2) == Rational(1,1))
    assert(Rational(1,2) + Rational(1,4) == Rational(3,4))
    assert(Rational(2,3) - Rational(1,2) == Rational(1,6))

    assert((Rational(1,4) * 4) == Rational(1, 1))
    assert((4 * Rational(1,4)) == Rational(1, 1))

    try {
      Rational(1,0)
      assert(false)
    } catch {
      case _: IllegalArgumentException => println("Oh yeah!")
      case _: Throwable => assert(false)
    }
  }
}

