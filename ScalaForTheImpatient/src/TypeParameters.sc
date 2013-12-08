object TypeParameters {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	
	//generic classes
	class Pair[T,S](val first : T , val second : S)
	
	val p1 = new Pair(3,"Hello")              //> p1  : TypeParameters.Pair[Int,String] = TypeParameters$$anonfun$main$1$Pair$
                                                  //| 1@197e6dc
	val p2 = new Pair(4,5)                    //> p2  : TypeParameters.Pair[Int,Int] = TypeParameters$$anonfun$main$1$Pair$1@1
                                                  //| b57655
	
	p1.first                                  //> res0: Int = 3
	
	p1.first + p2.second                      //> res1: Int = 8
	
	//generic functions
	
	def getMiddle[T](a : Array[T]) = a(a.length/2)
                                                  //> getMiddle: [T](a: Array[T])T
	val f = getMiddle[Char]_                  //> f  : Array[Char] => Char = <function1>
	getMiddle("HelloWorld".toArray)           //> res2: Char = W
	f.apply("HelloWorld".toArray)             //> res3: Char = W
	
	//upper bounds on a type
	// T must be subtype of Comparable[T]
	class Pop[T <: Comparable[T]](val first : T, val second : T){
		def smaller = if (first.compareTo(second) < 0) first else second
	}
	
	val p = new Pop("abraca","third")         //> p  : TypeParameters.Pop[String] = TypeParameters$$anonfun$main$1$Pop$1@1d809
                                                  //| 45
  println(p.smaller)                              //> abraca
  
  //R must be supertpe of T
  class Poo[T](val first : T, val second : T){
  	def replaceFirst[R >: T](newFirst : R) = new Poo(newFirst, second)
	  }
	  
	  val p0 = new Poo(3,4)                   //> p0  : TypeParameters.Poo[Int] = TypeParameters$$anonfun$main$1$Poo$1@44b009
	  val p00 = p0.replaceFirst(new Object()) //> p00  : TypeParameters.Poo[Any] = TypeParameters$$anonfun$main$1$Poo$1@1812b5
                                                  //| 1
	  p0.first                                //> res4: Int = 3
	  p0.second                               //> res5: Int = 4
	  p00.first                               //> res6: Any = java.lang.Object@142f67d
	  p00.second                              //> res7: Any = 4
	  
	// View Bounds
	class ViewBound[T <% Ordered[T]](val first : T , val second : T){
		def smaller = if (first < second) first else second
	}
	
	val vb = new ViewBound(3,4)               //> vb  : TypeParameters.ViewBound[Int] = TypeParameters$$anonfun$main$1$ViewBo
                                                  //| und$1@dd8cfc
	vb.smaller                                //> res8: Int = 3
	
	def firstLast[A,C](it:C)(implicit ev: C <:< Iterable[A]) = (it.head, it.last)
                                                  //> firstLast: [A, C](it: C)(implicit ev: <:<[C,Iterable[A]])(A, A)
	
	firstLast(List(1,2,3,4))                  //> res9: (Int, Int) = (1,4)
}