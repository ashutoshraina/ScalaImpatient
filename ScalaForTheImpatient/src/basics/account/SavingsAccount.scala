package basics.account


//Extend the Account class to create a SavingsAccount class that earns interest 
// every month when earnMonthlyInterest is called , has 3 free deposits or withdrawls
// every month. reset the transaction count in earnmonthlyInterest method

class SavingsAccount( initialBalance : Double ) extends Account( initialBalance ) {

	private var discountCounter : Int = 0

	override def deposit( amount : Double ) = {

		discountCounter += 1

		if ( discountCounter <= 3 )
			super.deposit( amount )
		else
			super.deposit( amount - 1 )

	}

	override def withdraw( amount : Double ) = {

		discountCounter += 1

		if ( discountCounter <= 3 )
			super.withdraw( amount )
		else
			super.withdraw( amount - 1 )

	}

	def earnMonthlyInterest( rateOfInterest : Double ) = {

		discountCounter = 0

		//calculate interest

		val interest = ( getBalance * rateOfInterest ) / ( 1200 )

		// deposit(interest) would be wrong since this isn't a transaction and we don't want to charge the user.
		//so calling the base class method directly

		super.deposit( interest )
	}

	def getDiscountCounter = {

		discountCounter;
	}

}