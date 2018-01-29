package cruft

import scala.math
import scala.io
import scala.util.{Success, Try}

object Easter extends App {

  while (true) {
    val year = io.StdIn.readLine("Input year: \n")
    Try(year.toInt) match {
      case Success(y) if y > 1581 && y < 3000 => println(findEaster(y))
      case _                                  => println("input is not a valid year")
    }
  }
  def findEaster(year: Int): Option[(Int, Int, Int)] = {
    if (year > 1581 && year < 3000) {
      val a: Int = year % 19
      val b: Int = math.floor(year / 100).toInt
      val c: Int = year % 100
      val d: Double = math.floor(b / 4)
      val e: Int = b % 4
      val f: Int = math.floor((b + 8) / 25).toInt
      val g: Int = math.floor((b - f + 1) / 3).toInt
      val h: Double = (19 * a + b - d - g + 15) % 30
      val s: Double = math.floor(c / 4)
      val k: Int = c % 4
      val q: Double = (32 + 2 * e + 2 * s - h - k) % 7
      val m: Double = math.floor((a + 11 * h + 22 * q) / 451)
      val month: Int = math.floor((h + q - 7 * m + 114) / 31).toInt
      val day: Int = (((h + q - 7 * m + 114) % 31) + 1).toInt
      Some(year, month, day)
    } else None
  }
}
