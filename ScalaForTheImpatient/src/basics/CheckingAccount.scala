package basics

// Extend the Account class to CheckingAccount that charges an 
// extra dollar for every deposit and withdrawal

class CheckingAccount( initialBalance : Double ) extends Account( initialBalance ) {

	override def deposit( amount : Double ) = {

		// deposit 1 dollar less
		super.deposit( amount - 1 )
	}

	override def withdraw( amount : Double ) = {

		// deduct an additional dollar
		super.withdraw( amount + 1 )
	}

}