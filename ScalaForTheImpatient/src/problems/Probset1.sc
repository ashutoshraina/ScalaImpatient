package problems

object Probset1 {
	println( "Welcome to the Scala worksheet" )
                                                  //> Welcome to the Scala worksheet

	def flatten1( input : List[ Any ] ) : List[Any] = input flatMap {
	  case ys : List[_] => flatten1(ys)
		case y => List(y)
	}                                         //> flatten1: (input: List[Any])List[Any]

	List( List( 1, 1 ) ).flatten              //> res0: List[Int] = List(1, 1)

	val fList = flatten1( List( List( 1, 2 ), List( 3, 4 ) ) )
                                                  //> fList  : List[Any] = List(1, 2, 3, 4)

	List( List( 1, 2 ), List( 3, 4 ) ).flatten//> res1: List[Int] = List(1, 2, 3, 4)

 val repeated = List('a', 'a', 'a', 'a', 'b', 'c',
  'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')         //> repeated  : List[Char] = List(a, a, a, a, b, c, c, a, a, d, e, e, e, e)
  
 def pack[T] (input : List[T]) : List[List[T]]
  = input match {
    case Nil => Nil
    case x :: xs =>
        val (first, rest) = input.span(y => y == x)
        first :: pack(rest)
  }                                               //> pack: [T](input: List[T])List[List[T]]
  
  pack(repeated)                                  //> res2: List[List[Char]] = List(List(a, a, a, a), List(b), List(c, c), List(a,
                                                  //|  a), List(d), List(e, e, e, e))
  val rle = pack(repeated) map (r => (r.head,r.length))
                                                  //> rle  : List[(Char, Int)] = List((a,4), (b,1), (c,2), (a,2), (d,1), (e,4))
  rle map (d => List(d._1 * d._2))                //> res3: List[List[Int]] = List(List(388), List(98), List(198), List(194), List
                                                  //| (100), List(404))
  fList map(d => List(d,d)) flatten               //> res4: List[Any] = List(1, 1, 2, 2, 3, 3, 4, 4)
  
  def repeatTimes[T](input : List[T], n : Int) =
  input flatMap { List.make(n,_) }                //> repeatTimes: [T](input: List[T], n: Int)List[T]
  
  repeatTimes(fList,3)                            //> res5: List[Any] = List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4)
  
  List(fList take 3, fList drop 3)                //> res6: List[List[Any]] = List(List(1, 2, 3), List(4))
  
  (repeated drop 4) ++ (repeated take 4)          //> res7: List[Char] = List(b, c, c, a, a, d, e, e, e, e, a, a, a, a)
 
 def dropNTh[T](input : List[T], n : Int) = {
   input.zipWithIndex filter (v => (v._2 + 1) % n != 0) map (d => d._1)
    }                                             //> dropNTh: [T](input: List[T], n: Int)List[T]
    repeated                                      //> res8: List[Char] = List(a, a, a, a, b, c, c, a, a, d, e, e, e, e)
    dropNTh (repeated , 4)                        //> res9: List[Char] = List(a, a, a, b, c, c, a, d, e, e, e)
    
  def slice[T] (input : List[T], start : Int , end : Int) = {
  input.zipWithIndex filter (v => v._2 > start -1 && v._2 < end) map (_._1)
  }                                               //> slice: [T](input: List[T], start: Int, end: Int)List[T]
  
  slice(List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k),3,7)
                                                  //> res10: List[Symbol] = List('d, 'e, 'f, 'g)
  
  val temp = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
                                                  //> temp  : List[Symbol] = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  (temp drop 3) ++ (temp take 3)                  //> res11: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
  
  (temp.reverse take 2) ++ (temp.reverse drop 2)  //> res12: List[Symbol] = List('k, 'j, 'i, 'h, 'g, 'f, 'e, 'd, 'c, 'b, 'a)

  (for(i <- 4 until 9 + 1) yield i  ).toList      //> res13: List[Int] = List(4, 5, 6, 7, 8, 9)
  
  def rangeTailRecursive(start : Int , end : Int) : List[Int] = {
    def inner(end : Int , result : List[Int]) :List[Int] = {
      if (end < start) result
      else {
      println(end :: result)
      inner(end - 1 , end :: result)}
    }
    
    inner(end, Nil)
  }                                               //> rangeTailRecursive: (start: Int, end: Int)List[Int]
  
  rangeTailRecursive(4,9)                         //> List(9)
                                                  //| List(8, 9)
                                                  //| List(7, 8, 9)
                                                  //| List(6, 7, 8, 9)
                                                  //| List(5, 6, 7, 8, 9)
                                                  //| List(4, 5, 6, 7, 8, 9)
                                                  //| res14: List[Int] = List(4, 5, 6, 7, 8, 9)
  (4 :: List(5))                                  //> res15: List[Int] = List(4, 5)
  
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post)  => (pre ::: post, e)
    case (pre, Nil)        => throw new NoSuchElementException
  }                                               //> removeAt: [A](n: Int, ls: List[A])(List[A], A)
  
  
}