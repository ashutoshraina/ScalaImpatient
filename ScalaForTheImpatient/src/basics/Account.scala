package basics

class Account( initialBalance : Double ) {

	private var balance = initialBalance;

	def deposit( amount : Double ) = {

		balance += amount
		balance

	}

	def withdraw( amount : Double ) = {

		balance -= amount
		balance

	}

	def getBalance = {
		balance
	}
}