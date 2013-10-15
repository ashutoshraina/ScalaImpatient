package hof

object playground {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(25); 
  
val fun = Math.ceil _;System.out.println("""fun  : Double => Double = """ + $show(fun ));$skip(38); 
def fun2(d : Double) : Double = d * 2;System.out.println("""fun2: (d: Double)Double""");$skip(19); 
val funky = fun2 _;System.out.println("""funky  : Double => Double = """ + $show(funky ));$skip(34); val res$0 = 
Array(3.14, 1.42, 2.0).map(funky);System.out.println("""res0: Array[Double] = """ + $show(res$0));$skip(55); 
  
def valueAtQuarter(f: (Double) => Double) = f(0.25);System.out.println("""valueAtQuarter: (f: Double => Double)Double""");$skip(28); val res$1 = 
valueAtQuarter(Math.ceil _);System.out.println("""res1: Double = """ + $show(res$1));$skip(42); 

(1 to 9).map("*" * _).foreach(println _);$skip(27); val res$2 = 
(1 to 4).reduceLeft(_ * _);System.out.println("""res2: Int = """ + $show(res$2));$skip(57); 

def mulBy(factor : Double) = (x : Double) => factor * x;System.out.println("""mulBy: (factor: Double)Double => Double""");$skip(23); 

val triple = mulBy(3);System.out.println("""triple  : Double => Double = """ + $show(triple ));$skip(20); 
println(triple(10));$skip(18); 

val yo = mulBy _;System.out.println("""yo  : Double => (Double => Double) = """ + $show(yo ));$skip(12); val res$3 = 

yo(20)(10);System.out.println("""res3: Double = """ + $show(res$3));$skip(104); 

def values(fun : (Int) => Int, low : Int, high : Int) = for (x <- low until high + 1) yield (x,fun(x));System.out.println("""values: (fun: Int => Int, low: Int, high: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]""");$skip(27); val res$4 = 
values(x => x * x , -5, 5);System.out.println("""res4: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$4));$skip(52); 
def max(a : Int,b : Int) : Int = if(a > b) a else b;System.out.println("""max: (a: Int, b: Int)Int""");$skip(41); val res$5 = 
Array(5,7,8,1,9,3,4).reduceLeft(_ max _);System.out.println("""res5: Int = """ + $show(res$5));$skip(74); 

def factorial (n : Int) = {
	if (n >= 1)
		(1 to n).reduceLeft(_ * _)
	};System.out.println("""factorial: (n: Int)AnyVal""");$skip(16); val res$6 = 
	
factorial(5);System.out.println("""res6: AnyVal = """ + $show(res$6));$skip(14); val res$7 = 

factorial(1);System.out.println("""res7: AnyVal = """ + $show(res$7));$skip(64); 

def factorial2(n : Int) = (1 to n).foldLeft(1)((b,a) => b * a);System.out.println("""factorial2: (n: Int)Int""");$skip(15); val res$8 = 
	factorial2(5);System.out.println("""res8: Int = """ + $show(res$8));$skip(117); 

def largest(fun : (Int) => Int, inputs : Seq[Int]) = {
	
	inputs.reduceLeft((a,b) => if(fun(a) >fun(b)) a else b)
};System.out.println("""largest: (fun: Int => Int, inputs: Seq[Int])Int""");$skip(94); 

def largest1(fun: (Int) => Int, input: Seq[Int]) = {
  input.map(fun).reduceLeft( _ max _)
};System.out.println("""largest1: (fun: Int => Int, input: Seq[Int])Int""");$skip(48); 

println(largest(x => 10 * x - x * x, 1 to 10));$skip(48); 
println(largest1(x => 10 * x - x * x, 1 to 10))}

}
