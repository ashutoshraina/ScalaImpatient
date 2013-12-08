object Arithmetic {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(150); 
  
  def Factors(x : Int) ={
  println(Math.sqrt(x).ceil.toInt)
    (for(i <- 1 until x /2
        if(x % i == 0)
       )
        yield i).toList  };System.out.println("""Factors: (x: Int)List[Int]""");$skip(105); 
        
  def gcd(a : Int , b : Int) : Int ={
    if(b == 0) Math.abs(a)
    else gcd(b , a % b)
    };System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(91); 
  def areCoPrime(a : Int, b : Int) : Boolean = {
    if(gcd(a,b) == 1) true else false
  };System.out.println("""areCoPrime: (a: Int, b: Int)Boolean""");$skip(24); val res$0 = 
  
  areCoPrime(35, 64);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(128); 
  
  def totient(x : Int) = {
    (for ( i <- 1 until x
          if(areCoPrime(i,x))
         )
    yield i).toList.length
  };System.out.println("""totient: (x: Int)Int""");$skip(17); val res$1 = 
  
  totient(10);System.out.println("""res1: Int = """ + $show(res$1));$skip(18); val res$2 = 
  
  Factors(315);System.out.println("""res2: List[Int] = """ + $show(res$2))}
  
}
