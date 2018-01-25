package geometry

import java.awt.Color

import org.scalatest.{FlatSpec, Matchers}
import org.scalamock.scalatest.MockFactory

class GeometricFigureTest extends FlatSpec with Matchers with MockFactory {
  "perimeter" should "return p for rectangle" in {
    val r = new Rectangle(2, 3)
    r.perimeter shouldBe 10.0
  }
  it should "return p for ellipse" in {
    val e = new Ellipse(2, 5)
    e.perimeter shouldBe 23.925656840788776
  }
  "area" should "return a for rectangle" in {
    val r = new Rectangle(2, 3)
    r.area shouldBe 6.0
  }
  it should "return a for ellipse" in {
    val e = new Ellipse(2, 5)
    e.area shouldBe 31.41592653589793
  }
  val mockFigure = stub[FigureCanvas]
  "draw" should "call figureCanvas properly" in {
    val r = new Rectangle(2, 3)
    mockFigure.setDrawingColor _ when *
    mockFigure.outlineRectangle _ when (*, *, *, *)
    r.draw(mockFigure)
    mockFigure.setDrawingColor _ verify Color.black
    mockFigure.outlineRectangle _ verify (r.p.x, r.p.y, r.w, r.h)
  }
  it should "fill and stroke when fill color is set" in {
    val e = new Ellipse(2, 3, fc = Some(Color.cyan))
    mockFigure.setDrawingColor _ when *
    mockFigure.fillEclipse _ when (*, *, *, *)
    mockFigure.outlineEclipse _ when (*, *, *, *)
    e.draw(mockFigure)
    inSequence {
      mockFigure.setDrawingColor _ verify Color.cyan
      mockFigure.fillEclipse _ verify (e.p.x, e.p.y, e.hr, e.vr)
      mockFigure.setDrawingColor _ verify Color.black
      mockFigure.outlineEclipse _ verify (e.p.x, e.p.y, e.hr, e.vr)
    }
  }
}
