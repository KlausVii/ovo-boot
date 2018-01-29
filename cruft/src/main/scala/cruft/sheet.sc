
  val f1: ((Int, Int) => Boolean) => ((Int, Int) => Boolean) = h => !h(_,_)
  def f2 (f: (Int, Int) => Boolean): (Int, Int) => Boolean = !f(_,_)
  val fg = f2(_ < _)
  fg(5, 4)

  def fibber: () => Int = {
    var f1 = 0
    var f2 = 1
    () => {
      {
        val res = f1
        f1 = f2
        f2 = res + f2
        res
      }
    }
  }

  def fiberStream: () => Int = {
    lazy val fibs:Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
    var i = 0
    () => {
      val res = fibs(i)
      i += 1
      res
    }
  }

  val fib = fibber

  fib()
  fib()
  fib()
  fib()
  fib()
  fib()


  val fub = fiberStream
  fub()
  fub()
  fub()
  fub()
  fub()
  fub()
  fub()
