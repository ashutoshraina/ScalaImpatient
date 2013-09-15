package oops

object Caesar {
  private val alphaU='A' to 'Z'
  private val alphaL='a' to 'z'
 
  def encode(text:String, key:Int)=text.map{
    case c if alphaU.contains(c) => rot(alphaU, c, key)
    case c if alphaL.contains(c) => rot(alphaL, c, key)
    case c => c
  }
  def decode(text:String, key:Int)=encode(text,-key)
  private def rot(a:IndexedSeq[Char], c:Char, key:Int)=a((c-a.head+key+a.size)%a.size)
}

trait Logger{
	def log(msg: String){
		println(msg)
	}
}

class CryptoLogger extends Logger{
	
	def cryptoLog(key : Int = 3 , msg: String){
		log(Caesar.encode(msg,key))
	}
}