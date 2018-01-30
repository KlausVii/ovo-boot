package GeometryManager

import canvas.FigureCanvas
import fraction.Fraction
import geometry.{Rectangle, Square}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class GeometryManagerTest extends FlatSpec with Matchers with MockFactory {
  val mockFigure = stub[FigureCanvas]

  "add" should "add a new figure to the class" in {
    val man = new GeometryManager(List(), mockFigure)
    man.add(new Rectangle(2, 3))
    man.geos should contain(new Rectangle(2, 3))
  }

  "remove" should "remove a figure that matches" in {
    val man = new GeometryManager(
      List(new Rectangle(2, 3), new Rectangle(2, 3), new Rectangle(3, 3)),
      mockFigure)
    man.remove(new Rectangle(2, 3))
    man.geos should have length 2
  }

  "clear" should "remove all figures" in {
    val man = new GeometryManager(
      List(new Rectangle(2, 3), new Rectangle(2, 3), new Rectangle(3, 3)),
      mockFigure)
    man.clear
    man.geos shouldBe empty
  }

  "scaleAll" should "scala all figures" in {
    val man = new GeometryManager(List(new Rectangle(2, 3)), mockFigure)
    man.scaleAll(Fraction(3), 1)
    man.geos shouldBe List(new Rectangle(6, 9))
  }
  it should "not scale small stuff" in {
    val man = new GeometryManager(List(new Rectangle(2, 3)), mockFigure)
    man.scaleAll(Fraction(3), 7)
    man.geos shouldBe List(new Rectangle(2, 3))
  }
  "totalArea" should "return total area of figures" in {
    val man =
      new GeometryManager(List(new Rectangle(2, 3), new Rectangle(2, 3)),
                          mockFigure)
    man.totalArea() shouldBe 12
  }
  it should "return 0 for empty" in {
    val man = new GeometryManager(List(), mockFigure)
    man.totalArea() shouldBe 0.0
  }
  "totalPerimeter" should "return total perimeter of figures" in {
    val man =
      new GeometryManager(List(new Rectangle(2, 3), new Rectangle(2, 3)),
                          mockFigure)
    man.totalPerimeter() shouldBe 20
  }

  "drawAll" should "call draw for all figures larger than min" in {
    mockFigure.setDrawingColor _ when *
    mockFigure.outlineRectangle _ when (*, *, *, *)
    val man =
      new GeometryManager(List(new Rectangle(2, 3), new Square(5)), mockFigure)

    man.drawAll(20)
    mockFigure.outlineRectangle _ verify (*, *, *, *) once
  }
}
