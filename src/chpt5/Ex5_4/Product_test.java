//Product_test.java
package chpt5.Ex5_4;

public class Product_test{
  public static void main(String args[]){
	  Product tt = new Product(11,"lenovo","desktop",5000);
	  Computer ter = new Computer(123,"dell","desktop",3000,516,"hp");
	  Laptop mac = new Laptop(456,"apple","laptop",3456,516,"hp",1.3,26);
	  System.out.println(tt);
	  System.out.println(ter);
	  System.out.println(mac);
  }
}
