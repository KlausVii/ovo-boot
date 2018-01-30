package fraction

class Fraction(val nom: Int, val denom: Int) {
  require(denom != 0)
  override def equals(obj: scala.Any): Boolean = obj match {
    case fraction: Fraction =>
      this.nom == fraction.nom && this.denom == fraction.denom
    case _ => false
  }
  override def toString: String = s"$nom/$denom"
  def +(f: Fraction): Fraction =
    Fraction(this.nom * f.denom + f.nom * this.denom, this.denom * f.denom)
  def -(f: Fraction): Fraction = this + -f
  def *(f: Fraction): Fraction =
    Fraction(this.nom * f.nom, this.denom * f.denom)
  def *(d: Double): Double = d * this.nom / this.denom
  def /(f: Fraction): Fraction = this * Fraction(f.denom, f.nom)
  def unary_- : Fraction = Fraction(-nom, denom)
  def unary_+ : Fraction = this
  def unary_~ : Fraction = Fraction(denom, nom)

}
object Fraction {
  def apply(n: Int, d: Int): Fraction = {
    val g: Int = math.abs(gcd(n, d))
    new Fraction(n / g, d / g)
  }
  def apply(n: Int) = new Fraction(n, 1)
  def apply() = new Fraction(1, 1)
  def apply(dd: Double): Fraction = {
    val s = dd.toString
    val nom = s.replace(".", "")
    val n = s.length - s.indexOf(".") - 1
    val denom = 1 + List.fill(n)("0").mkString
    Fraction.apply(nom.toInt, denom.toInt)
  }
  private def gcd(a: Int, b: Int): Int = (a, b) match {
    case (_, 0) => a
    case _      => gcd(b, a % b)
  }
}
