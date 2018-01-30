package scaling

import fraction.Fraction
import geometry.{Rectangle, Square}
import org.scalatest.{FlatSpec, Matchers}

class ScalingTest extends FlatSpec with Matchers {
  "scaleFigure" should "resize the dimensions of a rectangle" in {
    val g = new Rectangle(2, 3)
    val res = Scaling.scaleFigure(g, Fraction(3))
    res shouldBe new Rectangle(6, 9)
  }
  it should "resize the dimensions of a square" in {
    val g = new Square(3)
    val res = Scaling.scaleFigure(g, Fraction(3))
    res shouldBe new Square(9)
  }
}
