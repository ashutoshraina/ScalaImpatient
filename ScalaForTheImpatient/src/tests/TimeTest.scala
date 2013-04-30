package tests

import org.scalatest.junit.JUnitSuite
import org.junit.Test
import org.scalatest.Assertions
import basics.operations.Time

class TimeTest extends JUnitSuite {

	@Test
	def checkIfTimeCanBeInitialisedByPassingHoursAndMinutes = {

		val time = new Time( 12, 56 )
		assert( time.hour == 12 )
		assert( time.minute == 56 )
	}

	@Test
	def checkIfBeforeReturnsFalseWhenOtherTimeIsBefore = {

		val first = new Time( 12, 56 )
		val other = new Time( 11, 59 )
		assert( first.before( other ) )
	}

	@Test
	def checkIfBeforeReturnsFalseWhenOtherTimeIsAfter = {

		val first = new Time( 9, 56 )
		val second = new Time( 11, 59 )
		assert( !first.before( second ) )
	}
}