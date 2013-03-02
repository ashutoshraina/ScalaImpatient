package basics

import scala.collection.mutable.ArrayBuffer

object HelloWorld {

  def main(args: Array[String]): Unit = {
    
   // MapOperations.DiscountedMap();
    MapOperations.CountWords();
  }

  private def CallControlStructures() = {
    
    // val result = ControlStructures.FindFirstMultiple(List.range(1, 50, 1))
    //println (result)
    
   // val allMultiples = ControlStructures.FindAllMultiples(List.range(1,100,1))
   // for(t <- allMultiples)
   // println(t)
 
   // ControlStructures.ReversePrint(10)
    
    //println(ControlStructures.ComputePower(3,4))
    
  }
 
  private def CallArrayOperations() = {
    
    //val swappedArray =  ArrayOperations.SwapAdjacent(Array(1,2,3,4,5,6))
    //swappedArray.foreach(r => println(r))
    
    //var swappedArray = ArrayOperations.SwapAdjacentAndCreateNewArrayTheFunctionalWay(Array(1,2,3,4,5,6))
    //swappedArray.foreach(r => print(r + "\t"))
   // println()
    //println(swappedArray.getClass());
    //swappedArray = ArrayOperations.SwapAdjacentAndCreateNewArrayTheFunctionalWay(Array(1,2,3,4,5))
    //swappedArray.foreach(r => print(r + "\t"))
    
    //val average = ArrayOperations.AverageForAnArrayOfDouble(Array(1.3,4.5,6.7,8.9))
    //println(average)

    //val reverseSort = ArrayOperations.ReverseSortArrayOfIntegers(Array(3,7,8,1,9))
    //reverseSort.foreach(r => println(r))
     
    //val reverseSortArrayBuffer = ArrayOperations.ReverseSortArrayBuffer(ArrayBuffer[Int](3,7,8,1,9))
    //reverseSortArrayBuffer.foreach(r => println(r))
  }
  
}
