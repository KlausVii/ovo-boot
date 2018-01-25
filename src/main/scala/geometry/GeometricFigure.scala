package geometry

import java.awt.Color

abstract class GeometricFigure(val strokeColor: Color,
                               val fillColor: Option[Color],
                               val p: Point) {
  def perimeter: Double
  def area: Double
  def draw(f: FigureCanvas): Unit = {
    fillColor match {
      case Some(c) => fill(f, c)
      case None    =>
    }
    stroke(f, strokeColor)
  }
  def fill(f: FigureCanvas, c: Color): Unit
  def stroke(f: FigureCanvas, c: Color): Unit
}

case class Point(x: Double, y: Double)

class Rectangle(val w: Double,
                val h: Double,
                sc: Color = Color.black,
                fc: Option[Color] = None,
                p: Point = Point(0, 0))
    extends GeometricFigure(sc, fc, p) {
  require(w > 0 && h > 0)
  override def perimeter: Double = 2 * w + 2 * h
  override def area: Double = w * h

  override def fill(f: FigureCanvas, c: Color): Unit = {
    f.setDrawingColor(c)
    f.fillRectangle(p.x, p.y, w, h)
  }

  override def stroke(f: FigureCanvas, c: Color): Unit = {
    f.setDrawingColor(c)
    f.outlineRectangle(p.x, p.y, w, h)
  }
}

class Square(s: Double,
             sc: Color = Color.black,
             fc: Option[Color] = None,
             p: Point)
    extends Rectangle(s, s, sc, fc, p)

class Ellipse(val vr: Double,
              val hr: Double,
              sc: Color = Color.black,
              fc: Option[Color] = None,
              p: Point = Point(0, 0))
    extends GeometricFigure(sc, fc, p) {
  require(vr > 0 && hr > 0)
  override def perimeter: Double =
    2 * math.Pi * math.sqrt((vr * vr + hr * hr) / 2)
  override def area: Double = math.Pi * vr * hr

  override def fill(f: FigureCanvas, c: Color): Unit = {
    f.setDrawingColor(c)
    f.fillEclipse(p.x, p.y, hr, vr)
  }

  override def stroke(f: FigureCanvas, c: Color): Unit = {
    f.setDrawingColor(c)
    f.outlineEclipse(p.x, p.y, hr, vr)
  }
}

class Circle(r: Double,
             sc: Color = Color.black,
             fc: Option[Color] = None,
             p: Point)
    extends Ellipse(r, r, sc, fc, p)
