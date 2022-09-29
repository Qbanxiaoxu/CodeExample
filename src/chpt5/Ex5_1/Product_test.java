//Product_test.java
package chpt5.Ex5_1;
public class Product_test{
  public static void main(String args[]){
	Computer apple = new Computer();
    apple.ID = 123;
    apple.name = "MacBook";
    apple.categories = "laptop";
    System.out.println(apple.getName());
    System.out.println(apple.getCategories());

    Laptop mac = new Laptop();
    mac.name = "myMacbook";
    mac.weight = 20;
    mac.thickness = 1.3;
    System.out.println(mac.getName());
    System.out.println(mac.getProcessorName());
    System.out.println(mac.getthickness());
  }
}
