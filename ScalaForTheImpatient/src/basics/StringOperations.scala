package basics

object StringOperations {
  
 def StringOperations(arg: String): Unit = {

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