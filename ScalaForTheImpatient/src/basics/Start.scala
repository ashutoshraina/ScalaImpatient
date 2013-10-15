package basics
import basics.shapes._

//Turns out an Object can extend App and then there is no need for a mains method
object Start extends App {

	//Print the command line arguments in the reverse order
	println( "This is where we start the program" )

	if ( args.length > 0 )
		println ( "You did supply me with some arguments. I am not interestd in processing hem right now." )

	Point( 3, 4 ).printCoordinates()
	
	val labeledPoint = new LabeledPoint("AwesomePoint",10,20)
	
	labeledPoint.printCoordinates
	labeledPoint.printPoint

}