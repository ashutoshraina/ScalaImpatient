object TypeParameters {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 

  println("Welcome to the Scala worksheet")
	
	//generic classes
	class Pair[T,S](val first : T , val second : S);$skip(102); 
	
	val p1 = new Pair(3,"Hello");System.out.println("""p1  : TypeParameters.Pair[Int,String] = """ + $show(p1 ));$skip(24); 
	val p2 = new Pair(4,5);System.out.println("""p2  : TypeParameters.Pair[Int,Int] = """ + $show(p2 ));$skip(12); val res$0 = 
	
	p1.first;System.out.println("""res0: Int = """ + $show(res$0));$skip(24); val res$1 = 
	
	p1.first + p2.second;System.out.println("""res1: Int = """ + $show(res$1));$skip(73); 
	
	//generic functions
	
	def getMiddle[T](a : Array[T]) = a(a.length/2);System.out.println("""getMiddle: [T](a: Array[T])T""");$skip(26); 
	val f = getMiddle[Char]_;System.out.println("""f  : Array[Char] => Char = """ + $show(f ));$skip(33); val res$2 = 
	getMiddle("HelloWorld".toArray);System.out.println("""res2: Char = """ + $show(res$2));$skip(31); val res$3 = 
	f.apply("HelloWorld".toArray)
	
	//upper bounds on a type
	// T must be subtype of Comparable[T]
	class Pop[T <: Comparable[T]](val first : T, val second : T){
		def smaller = if (first.compareTo(second) < 0) first else second
	};System.out.println("""res3: Char = """ + $show(res$3));$skip(237); 
	
	val p = new Pop("abraca","third");System.out.println("""p  : TypeParameters.Pop[String] = """ + $show(p ));$skip(21); 
  println(p.smaller)
  
  //R must be supertpe of T
  class Poo[T](val first : T, val second : T){
  	def replaceFirst[R >: T](newFirst : R) = new Poo(newFirst, second)
	  };$skip(182); 
	  
	  val p0 = new Poo(3,4);System.out.println("""p0  : TypeParameters.Poo[Int] = """ + $show(p0 ));$skip(43); 
	  val p00 = p0.replaceFirst(new Object());System.out.println("""p00  : TypeParameters.Poo[Any] = """ + $show(p00 ));$skip(12); val res$4 = 
	  p0.first;System.out.println("""res4: Int = """ + $show(res$4));$skip(13); val res$5 = 
	  p0.second;System.out.println("""res5: Int = """ + $show(res$5));$skip(13); val res$6 = 
	  p00.first;System.out.println("""res6: Any = """ + $show(res$6));$skip(14); val res$7 = 
	  p00.second
	  
	// View Bounds
	class ViewBound[T <% Ordered[T]](val first : T , val second : T){
		def smaller = if (first < second) first else second
	};System.out.println("""res7: Any = """ + $show(res$7));$skip(175); 
	
	val vb = new ViewBound(3,4);System.out.println("""vb  : TypeParameters.ViewBound[Int] = """ + $show(vb ));$skip(12); val res$8 = 
	vb.smaller;System.out.println("""res8: Int = """ + $show(res$8));$skip(81); 
	
	def firstLast[A,C](it:C)(implicit ev: C <:< Iterable[A]) = (it.head, it.last);System.out.println("""firstLast: [A, C](it: C)(implicit ev: <:<[C,Iterable[A]])(A, A)""");$skip(28); val res$9 = 
	
	firstLast(List(1,2,3,4));System.out.println("""res9: (Int, Int) = """ + $show(res$9))}
}
