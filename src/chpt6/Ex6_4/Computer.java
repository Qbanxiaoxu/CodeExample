//Computer.java
package chpt6.Ex6_4;
public class Computer extends Product
{
	protected int memory;
	protected String ProcessorName;

	int memory()
    {
       return memory;
    }
    String getProcessorName()
    {
       return ProcessorName;
    }
    void ads(){
    	System.out.println("This is the best you've ever seen!");
    }
  //实现OnlineShopping的四个方法
	public void addtoShoppingCart() {
		System.out.println("Computer:Add your selected item into the shoppingCart...");
	}
	public void orderItem() {
		System.out.println("Computer:Please order now...");
	}
	public void payment() {
		System.out.println("Computer:Please input your credit/debit card number...");		
	}
	public void shipping() {
		System.out.println("Computer:Please select shipping...");
	}
}


