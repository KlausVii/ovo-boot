
def fac( n: Int): BigInt = {
  def loop(m: Int, fac: BigInt): BigInt = {
    if (m == 0) fac
    else loop(m-1, fac*m)
  }
  loop(n, 1)
}

def Nmethod(n: Double) = {
  def methodRec(n: Double, est: Double): Double = {
    if ((math.abs(n - est * est) / n) < 0.000001) est
    else methodRec(n, (est + n / est) / 2)
  }
  methodRec(n, 1.0)
}

def gcd(a: Int, b: Int): Int = (a, b) match {
  case (_, 0) => a
  case _      => gcd(b, a % b)
}

def isPalindrome(s: String): Boolean = {
  val l = s.length
  if (l == 1 || l == 0) true
  else {
    if (s.head.toLower == s.last.toLower) isPalindrome(s.substring(1, l-1))
    else false
  }
}

isPalindrome("())(")


