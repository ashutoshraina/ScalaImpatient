package patternmatching

object playground {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	
	'r' match {
	case '+' => println("Yo")
	case 'r' => println("yoyo")
	case _ => println("haw!!")
	}                                         //> yoyo

(10,20) match {
		case (x,y) => println(y,x)
		case _ => println("notfound")
	}                                         //> (20,10)
	
	def leafSum[T](input : T) : Int = {
		input match {
		case ls : List[Any] => ls.map(leafSum _).sum
		case value : Int => value
		}
	}                                         //> leafSum: [T](input: T)Int
	
leafSum(List(1,3,5,7,List(5,6,7)))                //> res0: Int = 34

def binaryTree() = {

	sealed abstract class BinaryTree
	case class Leaf(value: Int) extends BinaryTree
	case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
	
	def treeSum(input : BinaryTree) : Int = input match {
  		case Leaf(value) => value
  		case Node(left,right) => treeSum(left) + treeSum(right)
  	}
  	
  	println(treeSum(
    Node(
      Node(Leaf(1), Leaf(2)),
      Node(Node(Leaf(3), Leaf(4)), Leaf(5)))))
      }                                           //> binaryTree: ()Unit
      
 binaryTree()                                     //> 15
 
 
 def Tree() = {

	sealed abstract class Tree
	case class Leaf(value: Int) extends Tree
	case class Node(children: Tree*) extends Tree
	
	def treeSum(input : Tree) : Int = input match {
  		case Leaf(value) => value
  		case Node(children @ _*) => children.map(treeSum _).sum
  	}
  	
println(treeSum(Node(Node(Leaf(3),Leaf(8)),Leaf(2),Node(Leaf(5)))))
      }                                           //> Tree: ()Unit
      
   Tree()                                         //> 18
   
   def OpTree() = {

	sealed abstract class Tree
	case class Leaf(value: Int) extends Tree
	case class Node(operator : Char ,children: Tree*) extends Tree
	
	def treeVal(input : Tree) : Int = input match {
  		case Leaf(value) => value
  		case Node('+', children @ _*) => children.map(treeVal _).reduceLeft(_ + _)
  		case Node('-', children @ _*) => children.map(treeVal _).foldLeft(0)(_ - _)
  		case Node('*', children @ _*) => children.map(treeVal _).reduceLeft(_ * _)
      case Node('/', children @ _*) => children.map(treeVal _).reduceLeft(_ / _)
      case Node(_, children @ _*) => children.map(treeVal _).reduceLeft(_ + _)
  	}
 println(treeVal(Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))))
	}                                         //> OpTree: ()Unit
	
	OpTree()                                  //> 21
	
	
	def sumList(list: List[Option[Int]]) = {
  list.flatMap(o => o).sum
}                                                 //> sumList: (list: List[Option[Int]])Int
sumList(List(Some(2), None, Some(4)))             //> res1: Int = 6
}