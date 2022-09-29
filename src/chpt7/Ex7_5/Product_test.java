package chpt7.Ex7_5;
import java.util.*;
public class Product_test{
  public static void main(String args[]){
	  ArrayList<Product> mylist= new ArrayList<Product>();
	  Product tt = new Product(11,"lenovo","desktop",5000);
	  Computer ter = new Computer(123,"dell","desktop",3000,516,"hp");
	  Laptop mac = new Laptop(456,"apple","laptop",3456,516,"hp",1.3,26);
	  mylist.add(tt);
	  mylist.add(ter);
	  mylist.add(mac);
	  for(int i=0; i<mylist.size(); i++){
	    	 System.out.println(mylist.get(i));
	    }
	   
   
  }
}


