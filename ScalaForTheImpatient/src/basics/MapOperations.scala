package basics

import scala.collection
import scala.io.Source

object MapOperations {
  
  //create a map and then create a second map with the same key and values reduced by ten percent
  
  def DiscountedMap () = {
    val myMap = new scala.collection.mutable.LinkedHashMap[String,Int]
    myMap.+=("Foo" -> 10 , "Bar" -> 20 , "Zoo" -> 30)   
    val discountedMap = myMap.mapValues(v => v * 0.9)
        //just printing for fun sake.. the job was done by the statement above.
    println(discountedMap)
 }
  
  //read a file and then count the number of times a word appears in the file. Use mutable map
  
  def CountWords() = {
    Source.fromFile("src/basics/Findings.md").getLines.toSeq
    										 .map(_.toLowerCase.trim).toSeq
    										 .groupBy(identity).mapValues(_.size)
    										 .foreach(println)
  }
  
  //repeat the above using an immutable map

}