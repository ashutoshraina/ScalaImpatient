object playground {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  2 +2                                            //> res0: Int(4) = 4
  
  def mulBy(factor : Double) = (x : Double) => x * factor
                                                  //> mulBy: (factor: Double)Double => Double
  mulBy(10)                                       //> res1: Double => Double = <function1>
}