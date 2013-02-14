package basics

import util.Sorting
import scala.collection
import scala.collection.mutable.ArrayBuffer

object ArrayOperations{

	//Write a method which swaps the adjacent elements in an array

   //solution 1
	def SwapAdjacent(input: Array[Int]) = {

		for( i <- 0 until (input.length - 1,2)){
		    val temp = input(i)
		    input(i) = input(i+1)
		    input(i+1) = temp
		}
		input
	}

	//solution 2
	def SwapAdjacentAndCreateNewArray(input: Array[Int]) = {

		for( i <- 0 until (input.length))
		  yield{
				  if(i % 2 == 0)
				    	if (i == input.length - 1)
				    		input(i)
				        else
				        	input(i + 1)
				     else
				       input(i - 1 )
				}
	}
	
	//solution 3
	
	def SwapAdjacentAndCreateNewArrayTheFunctionalWay(input: Array[Int]) = {
			input.grouped(2).flatMap(_.reverse).toArray
	}	

	// Given an array produce a new array that contains all positive values of the original array, in their
	// original order , followed by all values that are zero or negative in their original order
	
	//compute the average of an Array[Double]

	def AverageForAnArrayOfDouble(input: Array[Double]) = {
		var result : Double = 0
	    input.foreach(r => result += r)
	    result/input.length
	}
	
	//Reverse sort Array[Int] and ArrayBuffer[Int]
	
	def ReverseSortArrayOfIntegers(input: Array[Int]) = {
	  Sorting.quickSort(input);
	  input.reverse
	}
	
	def ReverseSortArrayBuffer(input: ArrayBuffer[Int]) = {
	  input.sortWith(_.longValue > _.longValue)
	}
	
	//Produce all values from an array with duplicates removed	
}