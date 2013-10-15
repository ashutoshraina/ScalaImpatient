trait List[T]{
	def head : T
	def isEmpty : Boolean
	def tail : List[T]
}
class Cons[T](val head : T , val tail : List[T]) extends List[T]{
	def isEmpty :  Boolean = false
}

class Nil[T] extends List[T]{
	def isEmpty :  Boolean = true
	def head : Nothing = throw new NoSuchElementException("Nil.head")
	def tail : Nothing = throw new NoSuchElementException("Nil.head")
}

object Week3Part2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(555); 
	
	def nth[T](index : Int, xs : List[T]) : T = {
		if(xs.isEmpty) throw new IndexOutOfBoundsException()
		if(index == 0) xs.head
		else nth(index - 1, xs.tail)
	};System.out.println("""nth: [T](index: Int, xs: List[T])T""");$skip(62); 
	
	val list = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : Cons[Int] = """ + $show(list ));$skip(15); val res$0 = 
	
	nth(2,list);System.out.println("""res0: Int = """ + $show(res$0));$skip(47); 
	
  println("Welcome to the Scala worksheet")}
}
