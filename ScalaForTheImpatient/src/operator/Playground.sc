package operator

object Playground {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val f1 = new Fraction(3,4)                      //> f1  : operator.Fraction = 3/4
  f1.+(new Fraction(7,6))                         //> res0: operator.Fraction = 23/12
  
  val Name(first,last) = "Ashutosh Raina"         //> 8
                                                  //| first  : String = Ashutosh
                                                  //| last  : String = Raina
val m1 = new Money(1,75)                          //> m1  : operator.Money = 1 : 75
val m2 = new Money(0,50)                          //> m2  : operator.Money = 0 : 50
m1.+(m2)                                          //> res1: operator.Money = 2 : 25

val bs = new BitSequence()                        //> bs  : operator.BitSequence = 00000000000000000000000000000000000000000000000
                                                  //| 00000000000000000
println(bs)                                       //> 0000000000000000000000000000000000000000000000000000000000000000
//for (i <- 16 to 47) bs(i) = 1
println(bs)                                       //> 0000000000000000000000000000000000000000000000000000000000000000
for (i <- 24 to 39) bs(i) = 01
println(bs)                                       //> 0000000000000000000000001111111111111111000000000000000000000000
println(bs(15) + " " + bs(16))                    //> 0 0

println(bs(10))                                   //> 0

def TestPath(in: String) {
  val RichFile(path, name, ext) = in
  println(path + "-->" + name + "-->" + ext)
}                                                 //> TestPath: (in: String)Unit
TestPath("/a/b/c.txt")                            //> /a/b/-->c-->.txt
TestPath("/a/b/c")                                //> /a/b/-->-->c
TestPath("c.txt")                                 //> -->c-->.txt
TestPath("c")                                     //> -->-->c
TestPath("/.c.txt")                               //> /-->.c-->.txt
val RichFileSeq(p1, p2, p3) = "a/b/c.txt"         //> yo the string is a/b/c.txt
                                                  //| p1  : String = a
                                                  //| p2  : String = b
                                                  //| p3  : String = c.txt
//println(p1 + " | " + p2 + " | " + p3)


}

object Name{
  
  def unapply(input : String) = {
  	val pos = input.indexOf(" ")
  	println(pos)
  	if(pos == -1) None
  	else Some((input.substring(0,pos)),(input.substring(pos+1)))
  	}
  	
  }
  
object RichFileSeq{

	def unapplySeq(in : String) : Option[Seq[String]] = {
		val str = in.trim.dropWhile(_ == '/')
		println("yo the string is " + str)
    if (str == "") None
    else Some(str.split("/"))
	}
}

object RichFile{
	
	def unapply(fileName : String) = {
		if(fileName.length() <= 0) None
		else{
			val (path, rest) = fileName.splitAt(fileName.lastIndexOf("/") + 1)
			val (name, ext) = rest.splitAt(rest.lastIndexOf("."))
			Some((path,name,ext))
		}
	}
	
}

class Fraction(n : Int , d : Int){

	private val num : Int = if (d == 0) 1 else n * sign(d) / gcd(n,d)
	private val den : Int = if (d == 0) 1 else d * sign(d) / gcd(n,d)
	override def toString = num + "/" + den
	private def sign(a : Int) = if(a > 0 ) 1 else if (a < 0) -1 else 0
	private def gcd(a : Int , b : Int) : Int = if(b == 0) Math.abs(a) else gcd(b , a % b)
	def + (that : Fraction) : Fraction = normalise((this.num * that.den + that.num * this.den),(this.den * that.den))
	def normalise(a : Int, b : Int) : Fraction = new Fraction(a/gcd(a,b),b/gcd(a,b))

}

class Money(d : Int, c : Int) {
	private val dollar = d
	private val cent = c
	override def toString() = dollar + " : " + cent
	def + (that : Money) : Money = {
		val cents = this.cent + that.cent
		val dollars = this.dollar + that.dollar
		if(cents < 100) new Money(dollars,cents)
		else if (cents == 100) new Money(dollars + 1,0)
		else new Money(dollars + 1,Math.abs(100 - cents))
	}
}

class BitSequence{
	var data : Long = 0
	override def toString() = {
		(for (i <- 63 to (0,-1)) yield (data >> i) & 1L ).mkString
	}
	
	def apply(n: Int) = {
		if(n >= 0 && n <= 63) (data >> n) & 1L else 0
	}
	
	def update(n: Int, b: Int) = {
    if (n >= 0 && n <= 63) {
      if (b == 0) data &= ~(1L << n)
      else data |= (1L << n)
    }
  }
}