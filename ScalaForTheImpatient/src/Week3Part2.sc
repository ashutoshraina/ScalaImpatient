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

object Week3Part2 {
	
	def nth[T](index : Int, xs : List[T]) : T = {
		if(xs.isEmpty) throw new IndexOutOfBoundsException()
		if(index == 0) xs.head
		else nth(index - 1, xs.tail)
	}                                         //> nth: [T](index: Int, xs: List[T])T
	
	val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : Cons[Int] = Cons@53a928f9
	
	nth(2,list)                               //> res0: Int = 3
	
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}