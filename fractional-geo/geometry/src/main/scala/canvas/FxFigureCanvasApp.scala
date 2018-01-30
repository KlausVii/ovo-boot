package canvas

import java.awt.Color

import geometry.{BoardedFigure, Ellipse, Point, Rectangle}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scalafx.application.JFXApp

object FxFigureCanvasApp extends JFXApp {

  val canvas = new FxFigureCanvas(FxFigureCanvasApp)

  try {
    val e = new Ellipse(100, 200, p = Point(500, 300), fc = Some(Color.blue))
    with BoardedFigure
    val e2 = new Rectangle(50, 60, p = Point(100, 100), fc = Some(Color.blue))
    with BoardedFigure
    e.draw(canvas)
    e2.draw(canvas)
  } catch {
    case e: Exception => println(e)
  }

}
