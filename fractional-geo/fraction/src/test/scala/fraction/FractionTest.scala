package fraction

import org.scalatest.{FlatSpec, Matchers}

class FractionTest extends FlatSpec with Matchers {
  "the constructor" should "create from 2 integers " in {
    val res = Fraction(1, 2)
    res.nom should be(1)
    res.denom should be(2)
  }
  it should "simplify fractions" in {
    val res = Fraction(10, 20)
    res.nom should be(1)
    res.denom should be(2)
  }
  it should "create from 1 int" in {
    val res = Fraction(2)
    res.nom should be(2)
    res.denom should be(1)
  }

  it should "create from no params input" in {
    val res = Fraction()
    res.nom should be(1)
    res.denom should be(1)
  }
  it should "0 denom should throw exception" in {
    assertThrows[IllegalArgumentException](Fraction(1, 0))
  }
  it should "create from a double input greater 1" in {
    val res = Fraction(11.5)
    res.nom should be(23)
    res.denom should be(2)
  }
  it should "create from a double input less than 1" in {
    val res = Fraction(0.33)
    res.nom should be(33)
    res.denom should be(100)
  }
  it should "create from a double input less than 0" in {
    val res = Fraction(-0.33)
    res.nom should be(-33)
    res.denom should be(100)
  }
  "add" should "sum 2 fractions" in {
    val f = Fraction(1, 3) + Fraction(1, 2)
    f should be(Fraction(5, 6))
  }
  "sub" should "subtract 2 fractions" in {
    val f = Fraction(1, 3) - Fraction(1, 2)
    f shouldBe Fraction(-1, 6)
  }
  "multiply" should "give product of 2 fractions" in {
    val f = Fraction(1, 3) * Fraction(1, 2)
    f shouldBe Fraction(1, 6)
  }
  "divide" should "give division of 2 fractions" in {
    val f = Fraction(1, 3) / Fraction(1, 2)
    f shouldBe Fraction(2, 3)
  }
  "unary -" should "turn + fraction to other sign" in {
    -Fraction(1, 2) should be(Fraction(-1, 2))
  }
  "unary -" should "turn - fraction to other sign" in {
    -Fraction(-1, 2) should be(Fraction(1, 2))
  }

  "inverse" should "invert the fraction" in {
    ~Fraction(1, 2) should be(Fraction(2))
  }

  "multiply by doublle" should "give product as double" in {
    val res = Fraction(1, 3) * 3.0
    res shouldBe 1.0
  }
}
