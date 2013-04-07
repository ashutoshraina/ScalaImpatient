package tests

import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit
import org.junit.Test
import org.junit.Before
import org.scalatest.prop.Checkers
import org.scalatest.Assertions
import scala.collection
import basics.Person

class PersonTest extends JUnitSuite with ShouldMatchersForJUnit {

  @Test
  def personCanBeInitialisedWithAPrimaryConstructor = {
   
   val person = new Person("Ashutosh Raina")
   Assertions.assert (person.firstName.equalsIgnoreCase("Ashutosh"))
   Assertions.assert (person.secondName.equalsIgnoreCase("Raina"))
  }
}