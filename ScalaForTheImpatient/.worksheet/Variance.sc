object Variance {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class Pair[T, S](val first: T, val second: S) {
    def swap() = new Pair(second, first)
  }

  val p0 = new Pair(1, "Hello")                   //> p0  : Variance.Pair[Int,String] = Variance$$anonfun$main$1$Pair$1@799410
  val p1 = p0.swap()                              //> p1  : Variance.Pair[String,Int] = Variance$$anonfun$main$1$Pair$1@1e7a6ae

  class MutablePair[T](var first: T, var second: T) {
    def swap() = {
      val temp = first
      first = second
      second = temp
    }
  }

  val p2 = new MutablePair(3, 4)                  //> p2  : Variance.MutablePair[Int] = Variance$$anonfun$main$1$MutablePair$1@18b
                                                  //| eb66
  p2.swap()
  p2.first                                        //> res0: Int = 4
  p2.second                                       //> res1: Int = 3

  class OtherPair[T, S](val first: T, val second: S){}
  
  def swap[T,S](other : OtherPair[T,S]) = {
  	new OtherPair(other.second,other.first)
  }                                               //> swap: [T, S](other: Variance.OtherPair[T,S])Variance.OtherPair[S,T]
  
  val p3 = new OtherPair(List(1,2,3,4),4)         //> p3  : Variance.OtherPair[List[Int],Int] = Variance$$anonfun$main$1$OtherPair
                                                  //| $1@563456
  swap(p3).second                                 //> res2: List[Int] = List(1, 2, 3, 4)
 
 	def middle[T](iterable : Iterable[T]) ={
 		def take[T](iterable: Iterable[T], n: Int): T = {
      if (n == 0) iterable.head
      else take(iterable.tail, n - 1)
    }
    take(iterable, iterable.size / 2)
 	}                                         //> middle: [T](iterable: Iterable[T])T
 		
   class MPair[S, T](var left: S, var right: T) {
  	def swap()(implicit ev: S =:= T, ev2: T =:= S) {
    	val tmp = left
    	left = right
    	right = tmp
  	}
  
  	override def toString = "" + (left, right)
	}
  
  val p = new MPair(3,4)                          //> p  : Variance.MPair[Int,Int] = (3,4)
  p.swap()
  p.left                                          //> res3: Int = 4
}