package Week4

object Week4 {
	println( "Welcome to the Scala worksheet" )
                                                  //> Welcome to the Scala worksheet
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
		
	}                                         //> times: (chars: List[Char])List[(Char, Int)]

	times( List( 'c', 'a', 'a', 'd' ,'c','e') )
                                                  //> res0: List[(Char, Int)] = List((e,1), (d,1), (a,2), (c,2))
	 val foo = List( 'c', 'a', 'a', 'd' ,'c','e')
                                                  //> foo  : List[Char] = List(c, a, a, d, c, e)
	 
	 foo.head                                 //> res1: Char = c
	 
	 foo.tail.head                            //> res2: Char = a
	class Leaf(c : Char, i : Int) {
	//override def toString = c + " " + i
	}
  def makeOrderedLeafList(freqs: List[(Char, Int)]) = {
  	 for{pair <- freqs.sortBy((f) => f._2)}
  	 		yield new Leaf(pair._1,pair._2)
  	 	
  }                                               //> makeOrderedLeafList: (freqs: List[(Char, Int)])List[Week4.Week4.Leaf]
  makeOrderedLeafList(List(('a',5),('d',2),('e',6)))
                                                  //> res3: List[Week4.Week4.Leaf] = List(Week4.Week4$$anonfun$main$1$Leaf$1@55308
                                                  //| 275, Week4.Week4$$anonfun$main$1$Leaf$1@63c4fb04, Week4.Week4$$anonfun$main$
                                                  //| 1$Leaf$1@193bf6c8)
}