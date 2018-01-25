object test {
  def method(n: Double) = {
    def methodRec(n: Double, est: Double): Double = {
      if ((math.abs(n - est * est) / n) < 0.000001) est
      else methodRec(n, (est + n / est) / 2)
    }
    methodRec(n, 1.0)
  }
  method(4)
}