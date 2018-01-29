package cruft

import org.scalatest.FlatSpec

class NewtonTest extends FlatSpec {
  "Newton's method" should "return the approx the square root of 4 -> ~2 within 1e-6" in {
    val res = Newton.method(4)
    assert(res.isDefined)
    assert(math.abs(res.get - 2) < 0.000001)
  }
  it should "not return a value for negative numbers" in {
    assert(Newton.method(-4).isEmpty)
  }
}
