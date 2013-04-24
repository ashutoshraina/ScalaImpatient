package basics

//manufacturer , modelName and modelYear are read-only properties 
//licensePlate is a read-write property

class Car {

	private var _manufacturer : String = ""
	private var _modelName : String = ""
	private var _modelYear : Int = -1
	var licensePlate : String = ""

	def manufacturer = _manufacturer
	def modelName = _modelName
	def modelYear = _modelYear

	def this( manufacturer : String, modelName : String, modelYear : Int, licensePlate : String ) = {
		this()
		this._manufacturer = manufacturer
		this._modelName = modelName
		this._modelYear = modelYear
		this.licensePlate = licensePlate
	}

	def this( manufacturer : String, modelName : String ) = {
		this( manufacturer, modelName, -1, "" )
	}

	def this( manufacturer : String, modelName : String, modelYear : Int ) = {
		this( manufacturer, modelName, modelYear, "" )
	}

	def this( manufacturer : String, modelName : String, licensePlate : String ) = {
		this( manufacturer, modelName, -1, licensePlate )
	}

}