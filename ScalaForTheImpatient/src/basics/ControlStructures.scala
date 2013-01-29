package basics

//Given a list of numbers find the first number that is a multiple of 7
class ControlStructures {

  def FindFirstMultiple(input: List[Int]): Unit = {

    for (i <- input) {
      if (i % 7 == 0) {
        println(i)
      }
    }
  }
}