

def processList(list: List[Int]): Int = {
  def loop(list: List[Int], acc: Int): Int = list match {
    case Nil => acc
    case h::tail => loop(tail, acc+h)
  }
  loop(list, 0)
}


processList(List(1,2,3))

List(1,2,3).foldLeft(0)(_+_)

List("AUHE", "ASHD", "ASD").reduceRight()
