package tests

import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit
import org.junit.Test
import org.junit.Before
import org.scalatest.prop.Checkers
import org.scalatest.Assertions
import basics.Time

class TimeTest extends JUnitSuite with ShouldMatchersForJUnit{

  @Test
  def checkIfTimeCanBeInitialisedByPassingHoursAndMinutes = {
    
    val time = new Time(12,56)
    Assertions.assert(time.hour == 12)
    Assertions.assert(time.minute == 56)
  }
  
  @Test
  def checkIfBeforeReturnsFalseWhenOtherTimeIsBefore = {
    
    val first = new Time(12,56)
    val other = new Time(11,59)    
    Assertions.assert(first.before(other))
  }
  
   @Test
  def checkIfBeforeReturnsFalseWhenOtherTimeIsAfter = {
     
    val first = new Time(9,56)
    val second = new Time(11,59)
    Assertions.assert(!first.before(second))
  }
}