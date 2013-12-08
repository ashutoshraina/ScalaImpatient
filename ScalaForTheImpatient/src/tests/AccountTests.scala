package tests

import org.scalatest.junit.JUnitSuite
import org.junit.Test
import org.scalatest.Assertions
import basics._
import org.scalatest.matchers.ShouldMatchers
import basics.account.CheckingAccount
import basics.account.SavingsAccount

class AccountTests extends JUnitSuite with ShouldMatchers {

	@Test
	def currentAccountShouldDeductADollarWhenMakingADeposit = {

		val account = new CheckingAccount( 1000 )
		assert( account.deposit( 100 ) == 1099 )
	}

	@Test
	def currentAccountShouldDeductADollarWhenMakingAWithdrawal = {

		val account = new CheckingAccount( 1000 )
		assert( account.withdraw( 100 ) == 899 )
	}

	@Test
	def callingEarnMonthlyInterestForSavingsAccountShouldSetTheCountToZero = {

		val account = new SavingsAccount( 1000 )
		account.earnMonthlyInterest( 10 )
		assert( account.getDiscountCounter == 0 )
	}
}