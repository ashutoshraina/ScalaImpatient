import scala.io.Source;

object playground {
	println("Hello World")                    //> Hello World
	
def knapsack_aux(x: (Int, Int), is: List[Int]): List[Int] = {
  for {
    w <- is.zip(is.take(x._1) ::: is.take(is.size - x._1).map(_ + x._2))
  } yield math.max(w._1, w._2)
}                                                 //> knapsack_aux: (x: (Int, Int), is: List[Int])List[Int]
 
def knapsack_rec(xs: List[(Int, Int)], is: List[Int]): List[List[Int]] = {
  xs match {
    case x :: xs => knapsack_aux(x, is) :: knapsack_rec(xs, knapsack_aux(x, is))
    case _ => Nil
  }
}                                                 //> knapsack_rec: (xs: List[(Int, Int)], is: List[Int])List[List[Int]]
 
/* knapsack(): return the value inside the knapsack
 * xs: list of items, pair of (weight, value)
 * k: size of the knapsack
 */
def knapsack(xs: List[(Int, Int)], k: Int): Int = {
  knapsack_rec(xs, List.fill(k)(0)).last.last
}                                                 //> knapsack: (xs: List[(Int, Int)], k: Int)Int
 
println(knapsack(List((1, 1), (2, 2)), 4))        //> 3
println(knapsack(List((1, 1), (2, 2)), 5))        //> 3
println(knapsack(List((1, 1), (2, 2), (2, 4)), 5))//> 6
  
  List((1,2))                                     //> res0: List[(Int, Int)] = List((1,2))
  val intPairs = Source
  .fromFile("C:\\Users\\Ashutosh\\Desktop\\Coursera\\AOAD-2\\Week3\\knapsack1.txt")
  .getLines.map { line =>
 					line.split(" ").take(2).map(_.toInt)
			}.map(_.toList).toList    //> intPairs  : List[List[Int]] = List(List(16808, 250), List(50074, 659), List
                                                  //| (8931, 273), List(27545, 879), List(77924, 710), List(64441, 166), List(844
                                                  //| 93, 43), List(7988, 504), List(82328, 730), List(78841, 613), List(44304, 1
                                                  //| 70), List(17710, 158), List(29561, 934), List(93100, 279), List(51817, 336)
                                                  //| , List(99098, 827), List(13513, 268), List(23811, 634), List(80980, 150), L
                                                  //| ist(36580, 822), List(11968, 673), List(1394, 337), List(25486, 746), List(
                                                  //| 25229, 92), List(40195, 358), List(35002, 154), List(16709, 945), List(1566
                                                  //| 9, 491), List(88125, 197), List(9531, 904), List(27723, 667), List(28550, 2
                                                  //| 5), List(97802, 854), List(40978, 409), List(8229, 934), List(60299, 982), 
                                                  //| List(28636, 14), List(23866, 815), List(39064, 537), List(39426, 670), List
                                                  //| (24116, 95), List(75630, 502), List(46518, 196), List(30106, 405), List(194
                                                  //| 52, 299), List(82189, 124), List(99506, 883), List(6753, 567), List(36717, 
                                                  //| 338), List(54439, 145), List(51502, 898), List(83872, 829), List(11138, 359
                                                  //| ), List(53178, 398), List(22295, 905), List(21610, 232), List(59746, 176), 
                                                  //| List(53636, 299), List(98143, 400), List(27969, 413), List(261, 558), List(
                                                  //| 41595, 9), List(16396, 969), List(19114, 531), List(71007, 963), List(97943
                                                  //| , 366), List(42083, 853), List(30768, 822), List(85696, 713), List(73672, 9
                                                  //| 02), List(48591, 832), List(14739, 58), List(31617, 791), List(55641, 680),
                                                  //|  List(37336, 7), List(97973, 99), List(49096, 320), List(83455, 224), List(
                                                  //| 12290, 761), List(48906, 127), List(36124, 507), List(45814, 771), List(352
                                                  //| 39, 95), List(96221, 845), List(12367, 535), List(25227, 395), List(41364, 
                                                  //| 739), List(7845, 591), List(36551, 160), List(8624, 948), List(97386, 218),
                                                  //|  List(95273, 540), List(99248, 386), List(13497, 886), List(40624, 421), Li
                                                  //| st(28145, 969), List(35736, 916), List(61626, 535), List(46043, 12), List(5
                                                  //| 4680, 153))
			
	var list = List[(Int,Int)]()              //> list  : List[(Int, Int)] = List()
	
	for(inner <- intPairs){
	list = list.+:(inner.head,inner.tail.head)
	}
	println(list.length)                      //> 100
println(knapsack(list, 2000))                     //> 895
	}
	