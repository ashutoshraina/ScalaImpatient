package tests

import org.scalatest.junit.JUnitSuite
import org.junit.Test
import org.junit.Before
import org.scalatest.Assertions
import scala.collection
import basics.Person

class PersonTest extends JUnitSuite {

	@Test
	def personCanBeInitialisedWithAPrimaryConstructor = {

		val person = new Person( "Ashutosh Raina" )
		assert ( person.firstName.equalsIgnoreCase( "Ashutosh" ) )
		assert ( person.secondName.equalsIgnoreCase( "Raina" ) )
	}
}