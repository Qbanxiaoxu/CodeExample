//Samples.java
package chpt3.Ex3_4;
public class Samples{
  public static void main(String args[]){
	  Product iphone = new Product();
	  Product ipad = new Product(10,"ipad2","computer",5000);
	  Product macbook = new Product(11,"apple","computer",9999);
	  
	  System.out.println("ipad price is: "+ipad.productPrice);
	  System.out.println("macbook price is: "+macbook.productPrice);
	  System.out.println(ipad);
	  System.out.println(macbook);
	  System.out.println(iphone);
	  
	  System.out.println("Total price of products is: "+Product.totalPrice);
	  System.out.println("Total number of Products is: "+Product.totalNumber);
	}  
}
