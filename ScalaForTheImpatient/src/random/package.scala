//Create a package random with functions nexctInt(): Int , nextDouble() : Double and setSeed(seed : Int) : unit 
//To generate random numbers, use the linear congruential generator

package object Random {

	private var previousInt : Int = 0
	private var previousDouble : Double = 0
	private var seedSet : Boolean = false
	private val a = 1664525
	private val b = 1013904223
	private val n = 32

	def nextInt() : Int = {

		previousInt = previousInt.*( a ).+( b.%( Math.pow( 2, n ) ).toInt )
		return previousInt
	}

	def nexyDouble() : Double = {

		previousDouble = previousDouble.*( a ).+( b.%( Math.pow( 2, n ) ) )
		return previousDouble
	}

	def setSeed( seed : Int ) : Unit = {

		if ( seedSet == false )
			previousInt = seed
		else
			throw new Exception( "Seed already set" )
	}

}