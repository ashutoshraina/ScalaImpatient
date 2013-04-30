package basics.item
import scala.collection.mutable._

class Bundle 
{
	var items : ArrayBuffer[Item] = new ArrayBuffer[Item]()
	private var description : String = "Not Available"
	private var count : Int = 0
		
	def addDescription(bundleDescription : String ) = {
		this.description = bundleDescription
		description
	}
	
	def getDescription = {
		description
	}
	
	def addItem(item : Item) = 	{
		items.+=(item)
		count+=1
	}
	
	def getNumberOfItems = {
		count
	}
	def getPriceOfBundle = {
		
		var totalPrice : Double = 0
		
		for ( i <- 0 until items.length)
			totalPrice+=items(i).price
			
		totalPrice
	}
}