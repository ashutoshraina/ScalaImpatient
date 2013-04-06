package basics

class Time (val hr : Int , val min : Int){
  
   def hour = hr
   def minute = min
   
   def before (other : Time) = {
     
     if(other.hour > this.hour)
       false
       else if(other.hour == this.hour && other.minute > this.minute) 
       false
       else
         true
   }
}