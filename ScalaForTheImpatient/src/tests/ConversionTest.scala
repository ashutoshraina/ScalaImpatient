package tests

import org.scalatest.junit.JUnitSuite
import org.junit.Test
import org.scalatest.Assertions
import basics.Conversion
import org.scalatest.matchers.ShouldMatchers

class ConversionTest extends JUnitSuite with ShouldMatchers {

  @Test
  def positiveInchesShouldBeConvertedToCentimetersCorrectly() = {
        
    assert(Conversion.inchesToCentimetres(10) == 25.4)
  } 
  
  @Test
  def positiveGallonsShouldBeConvertedToLitersCorrectly() = {
        
    assert(Conversion.gallonsToLiters(10) == 37.85)
  }
  
  @Test
  def positiveMilesShouldBeConvertedToKilometersCorrectly() = {
        
    assert(Conversion.milesToKilometers(10) == 16.1)
  }
  
  //This is a way of testing for exceptions
  @Test
  def negativeInchesShouldThrowException() = {
   
    val thrown = intercept[Exception]{
      Conversion.inchesToCentimetres(-1)
    }
    assert(thrown.getMessage == "inches can't be negative")
  }
  
  //This is another way of testing for exceptions, 
  //this seems a little easier to write but tougher to make sense of.
  
  @Test(  expected = classOf[Exception] )
	def negativeGallonsShouldThrowException()
	{
		Conversion.gallonsToLiters(-1)
	}
}