package basics.shapes

class Square extends java.awt.Rectangle{
	private var _startX = 0
	private var _startY = 0
	private var _width = 0
	
	def this(startX : Int, startY : Int, width : Int) = {
		this()
		_startX = startX
		_startY = startY
		_width = width
	}	
	
	def this(width : Int) = {
		this(0, 0, width)
	}	
}