object Variance {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet")

  class Pair[T, S](val first: T, val second: S) {
    def swap() = new Pair(second, first)
  };$skip(129); 

  val p0 = new Pair(1, "Hello");System.out.println("""p0  : Variance.Pair[Int,String] = """ + $show(p0 ));$skip(21); 
  val p1 = p0.swap()

  class MutablePair[T](var first: T, var second: T) {
    def swap() = {
      val temp = first
      first = second
      second = temp
    }
  };System.out.println("""p1  : Variance.Pair[String,Int] = """ + $show(p1 ));$skip(182); 

  val p2 = new MutablePair(3, 4);System.out.println("""p2  : Variance.MutablePair[Int] = """ + $show(p2 ));$skip(12); 
  p2.swap();$skip(11); val res$0 = 
  p2.first;System.out.println("""res0: Int = """ + $show(res$0));$skip(12); val res$1 = 
  p2.second

  class OtherPair[T, S](val first: T, val second: S){};System.out.println("""res1: Int = """ + $show(res$1));$skip(150); 
  
  def swap[T,S](other : OtherPair[T,S]) = {
  	new OtherPair(other.second,other.first)
  };System.out.println("""swap: [T, S](other: Variance.OtherPair[T,S])Variance.OtherPair[S,T]""");$skip(45); 
  
  val p3 = new OtherPair(List(1,2,3,4),4);System.out.println("""p3  : Variance.OtherPair[List[Int],Int] = """ + $show(p3 ));$skip(18); val res$2 = 
  swap(p3).second;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(216); 
 
 	def middle[T](iterable : Iterable[T]) ={
 		def take[T](iterable: Iterable[T], n: Int): T = {
      if (n == 0) iterable.head
      else take(iterable.tail, n - 1)
    }
    take(iterable, iterable.size / 2)
 	}
 		
   class MPair[S, T](var left: S, var right: T) {
  	def swap()(implicit ev: S =:= T, ev2: T =:= S) {
    	val tmp = left
    	left = right
    	right = tmp
  	}
  
  	override def toString = "" + (left, right)
	};System.out.println("""middle: [T](iterable: Iterable[T])T""");$skip(246); 
  
  val p = new MPair(3,4);System.out.println("""p  : Variance.MPair[Int,Int] = """ + $show(p ));$skip(11); 
  p.swap();$skip(9); val res$3 = 
  p.left;System.out.println("""res3: Int = """ + $show(res$3))}
}
