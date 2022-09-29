//Laptop.java
package chpt6.Ex6_4;
public class Laptop extends Computer 
{
	double thickness;
	double weight;
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
    //重写从computer继承而来的四个OnlineShopping方法
    public void addtoShoppingCart() {
		System.out.println("Laptop:Add your selected item into the shoppingCart...");
	}
	public void orderItem() {
		System.out.println("Laptop:Please order now...");
	}
	public void payment() {
		System.out.println("Laptop:Please input your credit/debit card number...");		
	}
	public void shipping() {
		System.out.println("Laptop:Please select shipping...");
	}
}
