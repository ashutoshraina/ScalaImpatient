package problems

object Probset1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
	println( "Welcome to the Scala worksheet" );$skip(129); 

	def flatten1( input : List[ Any ] ) : List[Any] = input flatMap {
	  case ys : List[_] => flatten1(ys)
		case y => List(y)
	};System.out.println("""flatten1: (input: List[Any])List[Any]""");$skip(32); val res$0 = 

	List( List( 1, 1 ) ).flatten;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(62); 

	val fList = flatten1( List( List( 1, 2 ), List( 3, 4 ) ) );System.out.println("""fList  : List[Any] = """ + $show(fList ));$skip(46); val res$1 = 

	List( List( 1, 2 ), List( 3, 4 ) ).flatten;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(94); 

 val repeated = List('a', 'a', 'a', 'a', 'b', 'c',
  'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e');System.out.println("""repeated  : List[Char] = """ + $show(repeated ));$skip(192); 
  
 def pack[T] (input : List[T]) : List[List[T]]
  = input match {
    case Nil => Nil
    case x :: xs =>
        val (first, rest) = input.span(y => y == x)
        first :: pack(rest)
  };System.out.println("""pack: [T](input: List[T])List[List[T]]""");$skip(20); val res$2 = 
  
  pack(repeated);System.out.println("""res2: List[List[Char]] = """ + $show(res$2));$skip(56); 
  val rle = pack(repeated) map (r => (r.head,r.length));System.out.println("""rle  : List[(Char, Int)] = """ + $show(rle ));$skip(35); val res$3 = 
  rle map (d => List(d._1 * d._2));System.out.println("""res3: List[List[Int]] = """ + $show(res$3));$skip(36); val res$4 = 
  fList map(d => List(d,d)) flatten;System.out.println("""res4: List[Any] = """ + $show(res$4));$skip(87); 
  
  def repeatTimes[T](input : List[T], n : Int) =
  input flatMap { List.make(n,_) };System.out.println("""repeatTimes: [T](input: List[T], n: Int)List[T]""");$skip(26); val res$5 = 
  
  repeatTimes(fList,3);System.out.println("""res5: List[Any] = """ + $show(res$5));$skip(38); val res$6 = 
  
  List(fList take 3, fList drop 3);System.out.println("""res6: List[List[Any]] = """ + $show(res$6));$skip(44); val res$7 = 
  
  (repeated drop 4) ++ (repeated take 4);System.out.println("""res7: List[Char] = """ + $show(res$7));$skip(126); 
 
 def dropNTh[T](input : List[T], n : Int) = {
   input.zipWithIndex filter (v => (v._2 + 1) % n != 0) map (d => d._1)
    };System.out.println("""dropNTh: [T](input: List[T], n: Int)List[T]""");$skip(13); val res$8 = 
    repeated;System.out.println("""res8: List[Char] = """ + $show(res$8));$skip(27); val res$9 = 
    dropNTh (repeated , 4);System.out.println("""res9: List[Char] = """ + $show(res$9));$skip(147); 
    
  def slice[T] (input : List[T], start : Int , end : Int) = {
  input.zipWithIndex filter (v => v._2 > start -1 && v._2 < end) map (_._1)
  };System.out.println("""slice: [T](input: List[T], start: Int, end: Int)List[T]""");$skip(66); val res$10 = 
  
  slice(List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k),3,7);System.out.println("""res10: List[Symbol] = """ + $show(res$10));$skip(65); 
  
  val temp = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k);System.out.println("""temp  : List[Symbol] = """ + $show(temp ));$skip(33); val res$11 = 
  (temp drop 3) ++ (temp take 3);System.out.println("""res11: List[Symbol] = """ + $show(res$11));$skip(52); val res$12 = 
  
  (temp.reverse take 2) ++ (temp.reverse drop 2);System.out.println("""res12: List[Symbol] = """ + $show(res$12));$skip(46); val res$13 = 

  (for(i <- 4 until 9 + 1) yield i  ).toList;System.out.println("""res13: List[Int] = """ + $show(res$13));$skip(275); 
  
  def rangeTailRecursive(start : Int , end : Int) : List[Int] = {
    def inner(end : Int , result : List[Int]) :List[Int] = {
      if (end < start) result
      else {
      println(end :: result)
      inner(end - 1 , end :: result)}
    }
    
    inner(end, Nil)
  };System.out.println("""rangeTailRecursive: (start: Int, end: Int)List[Int]""");$skip(29); val res$14 = 
  
  rangeTailRecursive(4,9);System.out.println("""res14: List[Int] = """ + $show(res$14));$skip(17); val res$15 = 
  (4 :: List(5));System.out.println("""res15: List[Int] = """ + $show(res$15));$skip(258); 
  
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post)  => (pre ::: post, e)
    case (pre, Nil)        => throw new NoSuchElementException
  };System.out.println("""removeAt: [A](n: Int, ls: List[A])(List[A], A)""")}
  
  
}
