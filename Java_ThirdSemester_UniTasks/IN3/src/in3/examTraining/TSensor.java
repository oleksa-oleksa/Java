package in3.examTraining;

/*An abstract class is a class that is declared abstract — 
it may or may not include abstract methods. 
An abstract method is a method that is declared without an implementation 
(without braces, and followed by a semicolon)*/

public abstract class TSensor {
	
	protected double temperature;
	
	public double getT(){
		return temperature;
	}
	
	public double getT(long time){
		return temperature;
	}
}
