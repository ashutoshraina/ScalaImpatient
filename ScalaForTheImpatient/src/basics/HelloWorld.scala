package basics

import scala.collection.mutable.ArrayBuffer

object HelloWorld {

  def main(args: Array[String]): Unit = {
        
  }

  private def CallControlStructures() = {
    
     val result = ControlStructures.findFirstMultiple(List.range(1, 50, 1))
     println (result)
    
    val allMultiples = ControlStructures.findAllMultiples(List.range(1,100,1))
    for(t <- allMultiples)
    println(t)
 
    ControlStructures.reversePrint(10)
    
    println(ControlStructures.computePower(3,4))
    
  }
 
  private def CallArrayOperations() = {
    
    val swappedArray =  ArrayOperations.swapAdjacent(Array(1,2,3,4,5,6))
    swappedArray.foreach(r => println(r))
    
    var swappedArrayInAFunctionalWay = ArrayOperations.swapAdjacentAndCreateNewArrayTheFunctionalWay(Array(1,2,3,4,5,6))
    swappedArrayInAFunctionalWay.foreach(r => print(r + "\t"))
    println()
    println(swappedArray.getClass());
    
    swappedArrayInAFunctionalWay = ArrayOperations.swapAdjacentAndCreateNewArrayTheFunctionalWay(Array(1,2,3,4,5))
    swappedArrayInAFunctionalWay.foreach(r => print(r + "\t"))
    
    val average = ArrayOperations.averageForAnArrayOfDouble(Array(1.3,4.5,6.7,8.9))
    println(average)

    val reverseSort = ArrayOperations.reverseSortArrayOfIntegers(Array(3,7,8,1,9))
    reverseSort.foreach(r => println(r))
     
    val reverseSortArrayBuffer = ArrayOperations.reverseSortArrayBuffer(ArrayBuffer[Int](3,7,8,1,9))
    reverseSortArrayBuffer.foreach(r => println(r))
    
    ArrayOperations.removeDuplicates(Array(1,2,3,4,5,6,3,4,5))
  }
  
  private def CallMapOperations() = {
    
    MapOperations.discountedMap()
    MapOperations.countWords()
    MapOperations.countWordsWithImutableMap()
    MapOperations.minMax(Array(1,3,5,8,11))
    MapOperations.lteqgt(Array(1,3,45,8,99,10,11,14), 11)
    
  }
}
