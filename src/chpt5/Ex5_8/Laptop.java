//Laptop.java
package chpt5.Ex5_8;
public class Laptop extends Computer
{
	double thickness;
	double weight;
	
	Laptop(int b){
		super(b);
		System.out.println("Laptop Constructor...");
	}
	Laptop(){}  //Ĭ�Ϲ��췽��������new Laptop()����
    public double getthickness()
    {
      return thickness;
    }
    double getweight()
    {
      return weight;
    }
    void ads(){
    	System.out.println("Your best choice!");
    }
}
