package basics

//Write a scala object which has methods for converting 
//inches to centimeters, gallons to liters, and miles to kilometers

object Conversion {

  def inchesToCentimetres(inches : Double) = {
    
    if (inches < 0) 
    throw new Exception("inches can't be negative")
    inches * 2.54
  }
  
  def gallonsToLiters(gallons : Double) = {
    
    if(gallons < 0 )
      throw new Exception("gallons can't be negative")
    gallons * 3.785
  }
  
  def milesToKilometers(miles : Double) = {
    
    if(miles < 0 )
      throw new Exception("gallons can''t be negative")
    miles * 1.61
  }
  
}