package geometry
import canvas.FigureCanvas

class TextFigure(text: String, override val p: Point) extends Drawable {
  override def draw(f: FigureCanvas): Unit = ???
}
