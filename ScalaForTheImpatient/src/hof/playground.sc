package hof

object playground {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
val fun = Math.ceil _                             //> fun  : Double => Double = <function1>
def fun2(d : Double) : Double = d * 2             //> fun2: (d: Double)Double
val funky = fun2 _                                //> funky  : Double => Double = <function1>
Array(3.14, 1.42, 2.0).map(funky)                 //> res0: Array[Double] = Array(6.28, 2.84, 4.0)
  
def valueAtQuarter(f: (Double) => Double) = f(0.25)
                                                  //> valueAtQuarter: (f: Double => Double)Double
valueAtQuarter(Math.ceil _)                       //> res1: Double = 1.0

(1 to 9).map("*" * _).foreach(println _)          //> *
                                                  //| **
                                                  //| ***
                                                  //| ****
                                                  //| *****
                                                  //| ******
                                                  //| *******
                                                  //| ********
                                                  //| *********
(1 to 4).reduceLeft(_ * _)                        //> res2: Int = 24

def mulBy(factor : Double) = (x : Double) => factor * x
                                                  //> mulBy: (factor: Double)Double => Double

val triple = mulBy(3)                             //> triple  : Double => Double = <function1>
println(triple(10))                               //> 30.0

val yo = mulBy _                                  //> yo  : Double => (Double => Double) = <function1>

yo(20)(10)                                        //> res3: Double = 200.0

def values(fun : (Int) => Int, low : Int, high : Int) = for (x <- low until high + 1) yield (x,fun(x))
                                                  //> values: (fun: Int => Int, low: Int, high: Int)scala.collection.immutable.Ind
                                                  //| exedSeq[(Int, Int)]
values(x => x * x , -5, 5)                        //> res4: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((-5,25), (-
                                                  //| 4,16), (-3,9), (-2,4), (-1,1), (0,0), (1,1), (2,4), (3,9), (4,16), (5,25))
def max(a : Int,b : Int) : Int = if(a > b) a else b
                                                  //> max: (a: Int, b: Int)Int
Array(5,7,8,1,9,3,4).reduceLeft(_ max _)          //> res5: Int = 9

def factorial (n : Int) = {
	if (n >= 1)
		(1 to n).reduceLeft(_ * _)
	}                                         //> factorial: (n: Int)AnyVal
	
factorial(5)                                      //> res6: AnyVal = 120

factorial(1)                                      //> res7: AnyVal = 1

def factorial2(n : Int) = (1 to n).foldLeft(1)((b,a) => b * a)
                                                  //> factorial2: (n: Int)Int
	factorial2(5)                             //> res8: Int = 120

def largest(fun : (Int) => Int, inputs : Seq[Int]) = {
	
	inputs.reduceLeft((a,b) => if(fun(a) >fun(b)) a else b)
}                                                 //> largest: (fun: Int => Int, inputs: Seq[Int])Int

def largest1(fun: (Int) => Int, input: Seq[Int]) = {
  input.map(fun).reduceLeft( _ max _)
}                                                 //> largest1: (fun: Int => Int, input: Seq[Int])Int

println(largest(x => 10 * x - x * x, 1 to 10))    //> 5
println(largest1(x => 10 * x - x * x, 1 to 10))   //> 25

}