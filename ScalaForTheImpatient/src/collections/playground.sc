package collections
import scala.collection.mutable

object playground {

	println( "Welcome to the Scala worksheet" )
                                                  //> Welcome to the Scala worksheet
	//for(i <- (0 until 100).par) yield(i)
	// for(i <- (0 until 100).par) print(i + " ")

	def indexes( input : String ) = {
		val freq = scala.collection.mutable.Map[ Char, Set[ Int ] ]()

		input.zipWithIndex.foreach(
			p => {
				if ( !freq.contains( p._1 ) )
					freq.+=( ( p._1, ( Set( p._2 ) ) ) )
				else
					freq( p._1 ) += p._2
			} )
		freq
	}                                         //> indexes: (input: String)scala.collection.mutable.Map[Char,Set[Int]]

	indexes( "Mississippi" )                  //> res0: scala.collection.mutable.Map[Char,Set[Int]] = Map(M -> Set(0), s -> Se
                                                  //| t(2, 3, 5, 6), p -> Set(8, 9), i -> Set(1, 4, 7, 10))
	def indexes2( s : String ) = {
		s.zipWithIndex.foldLeft( Map[ Char, List[ Int ] ]() )(
			( m, p ) =>
				m + ( p._1 -> ( m.getOrElse( p._1, List[ Int ]() ) :+ p._2 ) )
		)
	}                                         //> indexes2: (s: String)scala.collection.immutable.Map[Char,List[Int]]
	println( indexes2( "Mississippi" ) )      //> Map(M -> List(0), i -> List(1, 4, 7, 10), s -> List(2, 3, 5, 6), p -> List(8
                                                  //| , 9))

	def removeZeros( input : mutable.LinkedList[ Int ] ) = {
		input.filter( f => f != 0 )
	}                                         //> removeZeros: (input: scala.collection.mutable.LinkedList[Int])scala.collecti
                                                  //| on.mutable.LinkedList[Int]
	println( removeZeros( mutable.LinkedList[ Int ]( 0, 1, 0, 2, 0, 3, 0 ) ) )
                                                  //> LinkedList(1, 2, 3)
	def corresponds( c : Iterable[ String ], m : Map[ String, Int ] ) = {
		c.flatMap( ( k ) => m.get( k ) )

	}                                         //> corresponds: (c: Iterable[String], m: Map[String,Int])Iterable[Int]
	println( corresponds(
		Array( "Tom", "Fred", "Harry" ),
		Map( "Tom" -> 3, "Dick" -> 4, "Harry" -> 5 ) ) )
                                                  //> ArrayBuffer(3, 5)

	def groupByColumn( input : Iterable[ Int ], columns : Int ) = input.grouped( columns )
                                                  //> groupByColumn: (input: Iterable[Int], columns: Int)Iterator[Iterable[Int]]
                                                  //| 

	groupByColumn( Array( 1, 2, 3, 4, 4, 6, 7 ), 3 ).foreach( println )
                                                  //> WrappedArray(1, 2, 3)
                                                  //| WrappedArray(4, 4, 6)
                                                  //| WrappedArray(7)
	def makeString[ T ]( c : Iterable[ T ], s : String = "" ) = {
		c.map( _.toString ).reduceLeft( _ + s + _ )
	}                                         //> makeString: [T](c: Iterable[T], s: String)String
	println( makeString( Array( 1, 2, 3, 4 ), "" ) )
                                                  //> 1234

	Array( 1, 2, 3, 4 ).mkString              //> res1: String = 1234

	val list = List( 1, 2, 3 )                //> list  : List[Int] = List(1, 2, 3)
	val list2 = list.updated( 0, 5 )          //> list2  : List[Int] = List(5, 2, 3)

}