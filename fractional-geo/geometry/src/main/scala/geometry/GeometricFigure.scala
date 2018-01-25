package geometry

import java.awt.Color

import canvas.FigureCanvas

abstract class GeometricFigure(val strokeColor: Color,
                               val fillColor: Option[Color],
                               val p: Point) {
  // abstract
  def perimeter: Double
  def area: Double
  def fill(f: FigureCanvas, c: Color): Unit
  def stroke(f: FigureCanvas, c: Color): Unit
  // concrete
  def draw(f: FigureCanvas): Unit = {
    fillColor match {
      case Some(c) => fill(f, c)
      case None    =>
    }
    stroke(f, strokeColor)
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[GeometricFigure]

  override def equals(other: Any): Boolean = other match {
    case that: GeometricFigure =>
      (that canEqual this) &&
        p == that.p
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(p)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

case class Point(x: Double, y: Double)

class Rectangle(val v: Double,
                val h: Double,
                sc: Color = Color.black,
                fc: Option[Color] = None,
                p: Point = Point(0, 0))
    extends GeometricFigure(sc, fc, p) {
  require(v > 0 && h > 0)
  override def perimeter: Double = 2 * v + 2 * h
  override def area: Double = v * h

  override def fill(f: FigureCanvas, c: Color): Unit = {
    f.setDrawingColor(c)
    f.fillRectangle(p.x, p.y, v, h)
  }

  override def stroke(f: FigureCanvas, c: Color): Unit = {
    f.setDrawingColor(c)
    f.outlineRectangle(p.x, p.y, v, h)
  }

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Rectangle]

  override def equals(other: Any): Boolean = other match {
    case that: Rectangle =>
      super.equals(that) &&
        (that canEqual this) &&
        v == that.v &&
        h == that.h
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(v, h)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class Square(s: Double,
             sc: Color = Color.black,
             fc: Option[Color] = None,
             p: Point = Point(0, 0))
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
    f.fillEllipse(p.x, p.y, hr, vr)
  }

  override def stroke(f: FigureCanvas, c: Color): Unit = {
    f.setDrawingColor(c)
    f.outlineEllipse(p.x, p.y, hr, vr)
  }

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Ellipse]

  override def equals(other: Any): Boolean = other match {
    case that: Ellipse =>
      (that canEqual this) &&
        vr == that.vr &&
        hr == that.hr
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(vr, hr)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class Circle(r: Double,
             sc: Color = Color.black,
             fc: Option[Color] = None,
             p: Point = Point(0, 0))
    extends Ellipse(r, r, sc, fc, p)
