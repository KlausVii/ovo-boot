package geometry

import canvas.FigureCanvas

class BitmapFigure(fileLocation: String, override val p: Point)
    extends Drawable {
  override def draw(f: FigureCanvas): Unit = ???
}
