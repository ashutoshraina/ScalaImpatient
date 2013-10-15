package operator

object Playground {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
  println("Welcome to the Scala worksheet");$skip(32); 
  
  val f1 = new Fraction(3,4);System.out.println("""f1  : operator.Fraction = """ + $show(f1 ));$skip(26); val res$0 = 
  f1.+(new Fraction(7,6));System.out.println("""res0: operator.Fraction = """ + $show(res$0));$skip(45); 
  
  val Name(first,last) = "Ashutosh Raina";System.out.println("""first  : String = """ + $show(first ));System.out.println("""last  : String = """ + $show(last ));$skip(25); 
val m1 = new Money(1,75);System.out.println("""m1  : operator.Money = """ + $show(m1 ));$skip(25); 
val m2 = new Money(0,50);System.out.println("""m2  : operator.Money = """ + $show(m2 ));$skip(9); val res$1 = 
m1.+(m2);System.out.println("""res1: operator.Money = """ + $show(res$1));$skip(28); 

val bs = new BitSequence();System.out.println("""bs  : operator.BitSequence = """ + $show(bs ));$skip(12); 
println(bs);$skip(44); 
//for (i <- 16 to 47) bs(i) = 1
println(bs);$skip(31); 
for (i <- 24 to 39) bs(i) = 01;$skip(12); 
println(bs);$skip(31); 
println(bs(15) + " " + bs(16));$skip(17); 

println(bs(10));$skip(112); 

def TestPath(in: String) {
  val RichFile(path, name, ext) = in
  println(path + "-->" + name + "-->" + ext)
};System.out.println("""TestPath: (in: String)Unit""");$skip(23); 
TestPath("/a/b/c.txt");$skip(19); 
TestPath("/a/b/c");$skip(18); 
TestPath("c.txt");$skip(14); 
TestPath("c");$skip(20); 
TestPath("/.c.txt");$skip(42); 
val RichFileSeq(p1, p2, p3) = "a/b/c.txt";System.out.println("""p1  : String = """ + $show(p1 ));System.out.println("""p2  : String = """ + $show(p2 ));System.out.println("""p3  : String = """ + $show(p3 ))}
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
