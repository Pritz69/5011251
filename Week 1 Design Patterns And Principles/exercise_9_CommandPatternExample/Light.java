package exercise_9_CommandPatternExample;

public class Light {
	 String lightname;
	 public Light(String name)
	 {
		 lightname=name;
	 }
	 public void turnOn() {
	     System.out.println(lightname+" Light is on.");
	 }
	
	 public void turnOff() {
	     System.out.println(lightname+" Light is off.");
	 }
}
