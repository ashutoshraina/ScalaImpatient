package basics

import scala.collection
import scala.io.Source
import scala.collection.immutable.Map

object MapOperations {
  
  //create a map and then create a second map with the same key and values reduced by ten percent
  
  def discountedMap () = {
    val myMap = new scala.collection.mutable.LinkedHashMap[String,Int]
    myMap.+=("Foo" -> 10 , "Bar" -> 20 , "Zoo" -> 30)   
    val discountedMap = myMap.mapValues(v => v * 0.9)
        //just printing for fun sake.. the job was done by the statement above.
    println(discountedMap)
 }
  
  //read a file and then count the number of times a word appears in the file. Use mutable map
  
  def countWords() = {
 
		  Source.fromFile("src/basics/Findings.md").getLines()
		  									  .mkString.split("\\s+")
											  .map(_.toLowerCase.trim)
											  .toSeq.groupBy(identity)
											  .mapValues(_.size)
											  .foreach(println)
  }
  
  //repeat the above using an immutable map

  def countWordsWithImutableMap() = {
    
			  Source.fromFile("src/basics/Findings.md")             // read from the file
			  .getLines.flatMap{ line =>                  			// for each line
			     line.split("\\s+")                       			// split the line into tokens
			       .groupBy(identity).mapValues(_.size)   			// count each token in the line
			  }                                           			// this produces an iterator of token counts
			  .toStream                                   			// make a Stream so we can groupBy
			  .groupBy(_._1)
			  .mapValues(_.map(_._2).sum)   			            // combine all the per-line counts
			  .foreach(println)
  }

  //write a function which returns a pair containing the smallest and the largest value in an array
  
  def minMax(values : Array[Int]) = {
    println(values.min,values.max)
    //Finding the index of the maximum or minimum value
    println(values.zipWithIndex.max._2)
  }
  
  //write a function that returns a triple of the count of values less v, equal to v and greater than v
  
  def lteqgt (values: Array[Int], v: Int) = {
    
    println (values.filter(f => f < v).length,values.filter(f => f == v).length,values.filter(f => f > v).length)
    
  }
}