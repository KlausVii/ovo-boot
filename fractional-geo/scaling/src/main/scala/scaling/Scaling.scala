package scaling

import fraction.{Converters, Fraction}
import geometry.{Ellipse, GeometricFigure, Rectangle}

object Scaling extends Converters {
  def scaleFigure(g: GeometricFigure, frac: Fraction): GeometricFigure =
    g match {
      case r: Rectangle => new Rectangle(frac * r.v, frac * r.h)
      case e: Ellipse   => new Ellipse(frac * e.vr, frac * e.hr)
      case _            => throw new IllegalArgumentException("Unsupported figure")
    }
}
