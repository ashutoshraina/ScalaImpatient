package basics

// Define a Point Class with a companion object so that you can construct Point 
// instances as Point(3,4)

class Point private (val x : Int , val y : Int){

	private var _x = x
	private var _y = y

	def printCoordinates() = {
	  println ("X : " + _x + " Y : " + _y)
	}
}

object Point 
{
	def apply ( x : Int ,  y : Int) = {
		new Point (x,y)
	}
  
}