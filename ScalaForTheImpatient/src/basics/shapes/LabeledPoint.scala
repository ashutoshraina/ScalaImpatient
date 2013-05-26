package basics.shapes

//create a class LabeledPoint that extends Point and takes a label value ,x ,y co-ordintes in the 
//constructor

class LabeledPoint(label : String , x : Int ,  y : Int) extends Point(x,y){

	def printPoint = {
		
		println(label + " X : " + x + " Y : " + y)
	}
}