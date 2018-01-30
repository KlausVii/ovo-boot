package GeometryManager

import canvas.FigureCanvas
import fraction.Fraction
import geometry.GeometricFigure
import scaling.Scaling

class GeometryManager(var geos: List[GeometricFigure],
                      val figureCanvas: FigureCanvas) {
  def add(g: GeometricFigure): Unit = {
    geos = g :: geos
  }
  def remove(g: GeometricFigure): Unit = {
    geos = geos.filter(_ != g) ++ geos.filter(_ == g).drop(1)
  }
  def clear(): Unit = {
    geos = List[GeometricFigure]()
  }
  def scaleAll(frac: Fraction, minArea: Double = 0): Unit = {
    geos =
      geos.map(g => if (g.area > minArea) Scaling.scaleFigure(g, frac) else g)
  }
  def drawAll(minArea: Double = 0) =
    for {
      x <- geos
      if x.area > minArea
    } yield x.draw(figureCanvas)

  def totalArea(): Double = geos.foldLeft(0.0)((acc, b) => acc + b.area)
  def totalPerimeter(): Double =
    geos.foldLeft(0.0)((acc, b) => acc + b.perimeter)
}
