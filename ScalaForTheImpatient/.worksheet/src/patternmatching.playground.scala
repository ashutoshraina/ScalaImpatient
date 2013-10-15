package patternmatching

object playground {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
  println("Welcome to the Scala worksheet");$skip(102); 
	
	'r' match {
	case '+' => println("Yo")
	case 'r' => println("yoyo")
	case _ => println("haw!!")
	};$skip(81); 

(10,20) match {
		case (x,y) => println(y,x)
		case _ => println("notfound")
	};$skip(137); 
	
	def leafSum[T](input : T) : Int = {
		input match {
		case ls : List[Any] => ls.map(leafSum _).sum
		case value : Int => value
		}
	};System.out.println("""leafSum: [T](input: T)Int""");$skip(38); val res$0 = 
	
leafSum(List(1,3,5,7,List(5,6,7)));System.out.println("""res0: Int = """ + $show(res$0));$skip(449); 

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
      };System.out.println("""binaryTree: ()Unit""");$skip(22); 
      
 binaryTree();$skip(364); 
 
 
 def Tree() = {

	sealed abstract class Tree
	case class Leaf(value: Int) extends Tree
	case class Node(children: Tree*) extends Tree
	
	def treeSum(input : Tree) : Int = input match {
  		case Leaf(value) => value
  		case Node(children @ _*) => children.map(treeSum _).sum
  	}
  	
println(treeSum(Node(Node(Leaf(3),Leaf(8)),Leaf(2),Node(Leaf(5)))))
      };System.out.println("""Tree: ()Unit""");$skip(17); 
      
   Tree();$skip(733); 
   
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
	};System.out.println("""OpTree: ()Unit""");$skip(13); 
	
	OpTree();$skip(75); 
	
	
	def sumList(list: List[Option[Int]]) = {
  list.flatMap(o => o).sum
};System.out.println("""sumList: (list: List[Option[Int]])Int""");$skip(38); val res$1 = 
sumList(List(Some(2), None, Some(4)));System.out.println("""res1: Int = """ + $show(res$1))}
}
