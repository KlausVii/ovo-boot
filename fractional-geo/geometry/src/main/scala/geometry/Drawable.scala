package geometry

import canvas.FigureCanvas

trait Drawable {
  val p: Point
  def draw(f: FigureCanvas) = {}
  def bounds(): (Point, Double, Double)
}
