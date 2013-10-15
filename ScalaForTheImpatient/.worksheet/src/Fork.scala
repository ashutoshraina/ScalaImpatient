
abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree

object Week4 {
	println( "Welcome to the Scala worksheet" )
	def times( chars : List[ Char ] ) = {
		
		val freq = scala.collection.mutable.Map[ Char, Int]()

		chars.zipWithIndex.foreach(
			p => {
				if ( !freq.contains( p._1 ) )
					freq.+=( ( p._1,  1 ) )
				else
					freq( p._1 ) += 1
			} )
		freq.toList
		
	}

	times( List( 'c', 'a', 'a', 'd' ,'c','e') )
	
	
	
  def makeOrderedLeafList(freqs: List[(Char, Int)]) = {
  	 val temp = freqs.sortBy((f) => f._2)
  	temp.flatMap(f => Leaf(f._1,f._2))
  }
  makeOrderedLeafList(List(('a',5),('d',2),('e',6)))
}
