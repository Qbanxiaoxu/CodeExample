//HomeTheater.java
package chpt5.Ex5_8;
public class HomeTheater{
	Computer lenovo;
	Stereo sharp;
	Laptop apple;
	
	HomeTheater(int i){ 
		lenovo = new Computer(i);
		sharp = new Stereo(i+2);
		apple = new Laptop(i=3);
	}
	
  public static void main(String args[]){
	  HomeTheater mytheater = new HomeTheater(3);
	
  }
}
