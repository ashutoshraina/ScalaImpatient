package tests

import org.scalatest.junit.JUnitSuite
import org.junit.Test
import org.scalatest.Assertions
import basics.Conversion
import org.scalatest.matchers.ShouldMatchers
import basics.item._

class ItemTests extends JUnitSuite with ShouldMatchers{

	@Test
	def checkIfItemsCanBeAddedToABundle() = {
		
		val bundle = new Bundle()
		bundle.addItem(new SimpleItem(10, "foo"))
		bundle.addItem(new SimpleItem(20, "bar"))
		println(bundle.getPriceOfBundle)
		assert(bundle.getPriceOfBundle == 30)
	}
}