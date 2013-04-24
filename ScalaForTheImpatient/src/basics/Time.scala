package basics

class Time( hr : Int, min : Int ) {

	def hour = hr
	def minute = min

	def before( other : Time ) = {

		if ( other.hour > this.hour )
			false
		else if ( other.hour == this.hour && other.minute > this.minute )
			false
		else
			true
	}
}