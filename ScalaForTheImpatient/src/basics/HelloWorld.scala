package basics

object HelloWorld {

  def main(args: Array[String]): Unit = {
    StringOperations("HelloWorld")
  }

  private def StringOperations(arg: String): Unit = {

    val temp = arg
    val head = temp.head
    val take = temp.take(3)
    val takeRight = temp.takeRight(2)
    val drop = temp.drop(3)
    val dropRight = temp.dropRight(3)

    println("We are working on the string : " + temp)
    println("head is " + head)
    println("take (3) is " + take)
    println("takeRight(2) is " + takeRight)
    println("drop (3) is " + drop)
    println("dropRight(3) is " + dropRight)
    println();
  }
}
/*
 * Findings methods are declared using def
 * void is Unit in Scala
 * A value declared as val can never be changed
 * A value declared with var can be changed
 * the types of the variable are decalred after the name of the variable
 * the return type is written after the parameters of the method
 * See the method declaration for clarity
 */
