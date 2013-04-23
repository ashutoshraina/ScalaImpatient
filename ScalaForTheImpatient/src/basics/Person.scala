package basics

class Person(val fullName : String){
  
  private var _firstName = fullName.split(" ").toIndexedSeq(0)
  private var _secondName = fullName.split(" ").toIndexedSeq(1)
  
  def firstName = _firstName
  def secondName = _secondName
  
  def printName = {
    
    println(firstName + " " + secondName)
  
  }
}