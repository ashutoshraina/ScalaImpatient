package basics

object HelloWorld {

  def main(args: Array[String]): Unit = {
    
   // val result = ControlStructures.FindFirstMultiple(List.range(1, 50, 1))
    //println (result)
    
   // val allMultiples = ControlStructures.FindAllMultiples(List.range(1,100,1))
   // for(t <- allMultiples)
   // println(t)
 
   // ControlStructures.ReversePrint(10)
    
    //println(ControlStructures.ComputePower(3,4))
    
    //val swappedArray =  ArrayOperations.SwapAdjacent(Array(1,2,3,4,5,6))
    //swappedArray.foreach(r => println(r))
    
    var swappedArray = ArrayOperations.SwapAdjacentAndCreateNewArrayTheFunctionalWay(Array(1,2,3,4,5,6))
    swappedArray.foreach(r => print(r + "\t"))
    println()
    println(swappedArray.getClass());
    swappedArray = ArrayOperations.SwapAdjacentAndCreateNewArrayTheFunctionalWay(Array(1,2,3,4,5))
    swappedArray.foreach(r => print(r + "\t"))
    
    println()
    val temp = ArrayOperations.SwapAdjacentAndCreateNewArray2(Array(1,2,3,4,5))
    temp.foreach(f => print(f))
    //StringOperations("HelloWorld")
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
