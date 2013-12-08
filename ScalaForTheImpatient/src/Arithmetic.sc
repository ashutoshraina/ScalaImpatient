object Arithmetic {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def Factors(x : Int) ={
  println(Math.sqrt(x).ceil.toInt)
    (for(i <- 1 until x /2
        if(x % i == 0)
       )
        yield i).toList  }                        //> Factors: (x: Int)List[Int]
        
  def gcd(a : Int , b : Int) : Int ={
    if(b == 0) Math.abs(a)
    else gcd(b , a % b)
    }                                             //> gcd: (a: Int, b: Int)Int
  def areCoPrime(a : Int, b : Int) : Boolean = {
    if(gcd(a,b) == 1) true else false
  }                                               //> areCoPrime: (a: Int, b: Int)Boolean
  
  areCoPrime(35, 64)                              //> res0: Boolean = true
  
  def totient(x : Int) = {
    (for ( i <- 1 until x
          if(areCoPrime(i,x))
         )
    yield i).toList.length
  }                                               //> totient: (x: Int)Int
  
  totient(10)                                     //> res1: Int = 4
  
  Factors(315)                                    //> 18
                                                  //| res2: List[Int] = List(1, 3, 5, 7, 9, 15, 21, 35, 45, 63, 105)
  
}