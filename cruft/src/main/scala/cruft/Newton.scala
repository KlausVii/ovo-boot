package cruft

import scala.util.{Success, Try}

case class Precision(p: Double)

object Newton extends App {

  implicit val p = Precision(0.000001)

  val n = io.StdIn.readLine("Input: \n")
  Try(n.toDouble) match {
    case Success(x) if x >= 0.0 => println(method(x))
    case _                      => throw new IllegalArgumentException
  }
  def method(n: Double)(implicit precision: Precision): Option[Double] = {
    def methodRec(n: Double, est: Double): Double = {
      if ((math.abs(n - est * est) / n) < precision.p) est
      else methodRec(n, (est + n / est) / 2)
    }
    if (n >= 0.0) {
      Some(methodRec(n, 1.0))
    } else None
  }
}
