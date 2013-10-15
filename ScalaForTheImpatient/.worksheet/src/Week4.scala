


object Week4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
	println( "Welcome to the Scala worksheet" );$skip(263); 
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
		
	};System.out.println("""times: (chars: List[Char])List[(Char, Int)]""");$skip(47); val res$0 = 

	times( List( 'c', 'a', 'a', 'd' ,'c','e') );System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(143); 
	
	
  def makeOrderedLeafList(freqs: List[(Char, Int)]) = {
  	 val temp = freqs.sortBy((f) => f._2)
  	temp.flatMap(f => Leaf(f._1,f._2))
  };System.out.println("""makeOrderedLeafList: (freqs: List[(Char, Int)])List[Nothing]""");$skip(53); val res$1 = 
  makeOrderedLeafList(List(('a',5),('d',2),('e',6)));System.out.println("""res1: List[Nothing] = """ + $show(res$1))}
}
