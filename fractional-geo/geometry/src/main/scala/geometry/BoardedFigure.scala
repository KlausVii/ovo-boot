package geometry
import java.awt.Color

import canvas.FigureCanvas

trait BoardedFigure extends Drawable {
  override def draw(f: FigureCanvas): Unit = {
    f.setDrawingColor(Color.black)
    val (p, v, h) = bounds()
    f.outlineRectangle(p.x - 5, p.y - 5, h + 10, v + 10)
    super.draw(f)
  }
}
