package basics

object ArrayOperations{

	//Write a method which swaps the adjacent elements in an array

	def SwapAdjacent(input: Array[Int]) = {

		for( i <- 0 until (input.length - 1,2)){
		    val temp = input(i)
		    input(i) = input(i+1)
		    input(i+1) = temp
		}
		input
	}

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
	
	def SwapAdjacentAndCreateNewArrayTheFunctionalWay(input: Array[Int]) = {
			input.grouped(2).flatMap(_.reverse).toArray
	}
	
	def SwapAdjacentAndCreateNewArray2(input: Array[Int]) = {
			(for( i <- 0 until (input.length - 1, 2))
		  yield{
				  	if (i == input.length - 1)
				    	input(i)
				    (input(i + 1),input(i))
				}).toArray
	}
}