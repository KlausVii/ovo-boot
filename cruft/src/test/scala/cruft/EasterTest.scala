package cruft

import org.scalatest.FlatSpec

class EasterTest extends FlatSpec {
  "findEaster" should "return an easter date for a given year in correct range" in {
    assert(Easter.findEaster(2000).contains((2000, 4, 23)))
  }
  it should "return none for years before 1582" in {
    assert(Easter.findEaster(1581) equals None)
  }
  it should "return none for years after 2999" in {
    assert(Easter.findEaster(3000) equals None)
  }
}
