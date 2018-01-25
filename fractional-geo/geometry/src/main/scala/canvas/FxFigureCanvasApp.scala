package canvas

import java.awt.Color

import geometry.{Ellipse, Point}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scalafx.application.JFXApp

object FxFigureCanvasApp extends JFXApp {

  val canvas = new FxFigureCanvas(FxFigureCanvasApp)

  try {
    val e = new Ellipse(200, 200, p = Point(50, 50), fc = Some(Color.blue))
    e.draw(canvas)
  } catch {
    case e: Exception => println(e)
  }

}
