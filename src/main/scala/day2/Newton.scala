package day2

import scala.util.{Success, Try}

object Newton extends App {

  val n = io.StdIn.readLine("Input: \n")
  Try(n.toDouble) match {
    case Success(x) if x >= 0.0 => println(method(x))
    case _                      => throw new IllegalArgumentException
  }
  def method(n: Double): Option[Double] = {
    if (n >= 0.0) {
      var est = 1.0
      while ((math.abs(n - est * est) / n) > 0.000001) {
        est = (est + n / est) / 2
      }
      Some(est)
    } else None
  }
}
