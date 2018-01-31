package cruft

import org.scalatest.FlatSpec

class NewtonTest extends FlatSpec {
  "Newton's method" should "return the approx the square root of 4 -> ~2 within 1e-6" in {
    implicit val p = Precision(0.000001)
    val res = Newton.method(4)
    assert(res.isDefined)
    assert(math.abs(res.get - 2) < 0.000001)
  }
  it should "not return a value for negative numbers" in {
    implicit val p = Precision(0.000001)
    assert(Newton.method(-4).isEmpty)
  }
  it should "vary the precision according to implicit" in {
    implicit val p = Precision(0.01)
    val res = Newton.method(4)
    assert(res.isDefined)
    assert(math.abs(res.get - 2) < 0.01)
  }
}
