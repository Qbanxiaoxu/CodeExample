//RealityShow.java
package chpt6.Ex6_3;
public class RealityShow {
	String showName;

	public RealityShow(String sName){
		showName=sName;
	}	
	void joinShow(Actions act){
		System.out.println("let's join our "+showName+" adventrure...");
		act.dance();
		act.perform();
		act.sing();
	}	
}
