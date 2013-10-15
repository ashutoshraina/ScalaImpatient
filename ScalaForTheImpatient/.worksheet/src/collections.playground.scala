package collections
import scala.collection.mutable

object playground {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(120); 

	println( "Welcome to the Scala worksheet" );$skip(358); 
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
	};System.out.println("""indexes: (input: String)scala.collection.mutable.Map[Char,Set[Int]]""");$skip(28); val res$0 = 

	indexes( "Mississippi" );System.out.println("""res0: scala.collection.mutable.Map[Char,Set[Int]] = """ + $show(res$0));$skip(178); 
	def indexes2( s : String ) = {
		s.zipWithIndex.foldLeft( Map[ Char, List[ Int ] ]() )(
			( m, p ) =>
				m + ( p._1 -> ( m.getOrElse( p._1, List[ Int ]() ) :+ p._2 ) )
		)
	};System.out.println("""indexes2: (s: String)scala.collection.immutable.Map[Char,List[Int]]""");$skip(38); 
	println( indexes2( "Mississippi" ) );$skip(93); 

	def removeZeros( input : mutable.LinkedList[ Int ] ) = {
		input.filter( f => f != 0 )
	};System.out.println("""removeZeros: (input: scala.collection.mutable.LinkedList[Int])scala.collection.mutable.LinkedList[Int]""");$skip(76); 
	println( removeZeros( mutable.LinkedList[ Int ]( 0, 1, 0, 2, 0, 3, 0 ) ) );$skip(111); 
	def corresponds( c : Iterable[ String ], m : Map[ String, Int ] ) = {
		c.flatMap( ( k ) => m.get( k ) )

	};System.out.println("""corresponds: (c: Iterable[String], m: Map[String,Int])Iterable[Int]""");$skip(109); val res$1 = 
	println( corresponds(
		Array( "Tom", "Fred", "Harry" ),
		Map( "Tom" -> 3, "Dick" -> 4, "Harry" -> 5 ) ) );System.out.println("""res1: <error> = """ + $show(res$1));$skip(90); 

	def groupByColumn( input : Iterable[ Int ], columns : Int ) = input.grouped( columns );System.out.println("""groupByColumn: (input: Iterable[Int], columns: Int)Iterator[Iterable[Int]]""");$skip(71); val res$2 = 

	groupByColumn( Array( 1, 2, 3, 4, 4, 6, 7 ), 3 ).foreach( println );System.out.println("""res2: <error> = """ + $show(res$2));$skip(112); 
	def makeString[ T ]( c : Iterable[ T ], s : String = "" ) = {
		c.map( _.toString ).reduceLeft( _ + s + _ )
	};System.out.println("""makeString: [T](c: Iterable[T], s: String)String""");$skip(50); val res$3 = 
	println( makeString( Array( 1, 2, 3, 4 ), "" ) );System.out.println("""res3: <error> = """ + $show(res$3));$skip(32); val res$4 = 

	Array( 1, 2, 3, 4 ).mkString;System.out.println("""res4: <error> = """ + $show(res$4));$skip(26); 
	
	val list = List(1,2,3);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(31); 
val list2 = list.updated(0, 5);System.out.println("""list2  : List[Int] = """ + $show(list2 ))}

}
