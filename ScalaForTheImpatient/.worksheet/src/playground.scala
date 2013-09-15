object playground {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 

  println("Welcome to the Scala worksheet");$skip(11); val res$0 = 
  
  2 +2;System.out.println("""res0: Int(4) = """ + $show(res$0));$skip(62); 
  
  def mulBy(factor : Double) = (x : Double) => x * factor;System.out.println("""mulBy: (factor: Double)Double => Double""");$skip(12); val res$1 = 
  mulBy(10);System.out.println("""res1: Double => Double = """ + $show(res$1))}
}
