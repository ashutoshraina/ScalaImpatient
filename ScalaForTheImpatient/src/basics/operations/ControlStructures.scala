package basics.operations

object ControlStructures {

	//Given a list of numbers find the first number that is a multiple of 7

	//solution 1
	def findFirstMultiple( input : List[ Int ] ) : Int = {
		for ( i <- input if ( i % 7 == 0 ) ) return i
		0
	}

	// solution 2
	def findFirstMultipleWithoutForLoop( input : List[ Int ] ) : Int = {
		input.find( i => i % 7 == 0 ).getOrElse( 0 )
	}

	//Given a list of numbers find all the numbers that are divisible by 7

	//Note how the return type is inferred automatically by the compiler as the type if the last expression
	def findAllMultiples( input : List[ Int ] ) = {

		for (
			i <- input if ( i % 7 == 0 )
		) yield i
	}

	//write a procedure to print numbers from n to 0 
	def reversePrint( start : Int ) : Unit = {

		Range.inclusive( start, 0, -1 ).foreach( f => println( f ) )
	}

	/*
  * write a function that computes X^n
 * */
	def computePower( base : Int, power : Int ) : Int = {

		var result = base
		if ( power == 0 )
			result = 1
		else if ( power < 0 )
			result = 1 / computePower( base, -power )
		else
			result *= computePower( result, power - 1 )
		result

	}

}