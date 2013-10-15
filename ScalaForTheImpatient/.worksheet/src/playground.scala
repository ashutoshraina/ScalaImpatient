import scala.io.Source;

object playground {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
	println("Hello World");$skip(178); 
	
def knapsack_aux(x: (Int, Int), is: List[Int]): List[Int] = {
  for {
    w <- is.zip(is.take(x._1) ::: is.take(is.size - x._1).map(_ + x._2))
  } yield math.max(w._1, w._2)
};System.out.println("""knapsack_aux: (x: (Int, Int), is: List[Int])List[Int]""");$skip(195); 
 
def knapsack_rec(xs: List[(Int, Int)], is: List[Int]): List[List[Int]] = {
  xs match {
    case x :: xs => knapsack_aux(x, is) :: knapsack_rec(xs, knapsack_aux(x, is))
    case _ => Nil
  }
};System.out.println("""knapsack_rec: (xs: List[(Int, Int)], is: List[Int])List[List[Int]]""");$skip(231); 
 
/* knapsack(): return the value inside the knapsack
 * xs: list of items, pair of (weight, value)
 * k: size of the knapsack
 */
def knapsack(xs: List[(Int, Int)], k: Int): Int = {
  knapsack_rec(xs, List.fill(k)(0)).last.last
};System.out.println("""knapsack: (xs: List[(Int, Int)], k: Int)Int""");$skip(45); 
 
println(knapsack(List((1, 1), (2, 2)), 4));$skip(43); 
println(knapsack(List((1, 1), (2, 2)), 5));$skip(51); 
println(knapsack(List((1, 1), (2, 2), (2, 4)), 5));$skip(17); val res$0 = 
  
  List((1,2));System.out.println("""res0: List[(Int, Int)] = """ + $show(res$0));$skip(203); 
  val intPairs = Source
  .fromFile("C:\\Users\\Ashutosh\\Desktop\\Coursera\\AOAD-2\\Week3\\knapsack1.txt")
  .getLines.map { line =>
 					line.split(" ").take(2).map(_.toInt)
			}.map(_.toList).toList;System.out.println("""intPairs  : List[List[Int]] = """ + $show(intPairs ));$skip(34); 
			
	var list = List[(Int,Int)]();System.out.println("""list  : List[(Int, Int)] = """ + $show(list ));$skip(71); 
	
	for(inner <- intPairs){
	list = list.+:(inner.head,inner.tail.head)
	};$skip(25); 
	println(list.length);$skip(30); 
println(knapsack(list, 2000))}
	}
	