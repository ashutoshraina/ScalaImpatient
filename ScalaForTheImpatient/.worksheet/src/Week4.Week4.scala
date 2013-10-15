package Week4

object Week4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
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

	times( List( 'c', 'a', 'a', 'd' ,'c','e') );System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(47); 
	 val foo = List( 'c', 'a', 'a', 'd' ,'c','e');System.out.println("""foo  : List[Char] = """ + $show(foo ));$skip(14); val res$1 = 
	 
	 foo.head;System.out.println("""res1: Char = """ + $show(res$1));$skip(19); val res$2 = 
	 
	 foo.tail.head
	class Leaf(c : Char, i : Int) {
	//override def toString = c + " " + i
	};System.out.println("""res2: Char = """ + $show(res$2));$skip(222); 
  def makeOrderedLeafList(freqs: List[(Char, Int)]) = {
  	 for{pair <- freqs.sortBy((f) => f._2)}
  	 		yield new Leaf(pair._1,pair._2)
  	 	
  };System.out.println("""makeOrderedLeafList: (freqs: List[(Char, Int)])List[Week4.Week4.Leaf]""");$skip(53); val res$3 = 
  makeOrderedLeafList(List(('a',5),('d',2),('e',6)));System.out.println("""res3: List[Week4.Week4.Leaf] = """ + $show(res$3))}
}
