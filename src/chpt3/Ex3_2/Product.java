//Product.java
package chpt3.Ex3_2;
public class Product {
     int ID;
     String name;
     String categories; 
     double productPrice;

     Product(int id, String nm, String categ,double price)
     {
    	 ID =id;
    	 name=nm;
    	 categories = categ;
    	 productPrice = price;
     }
    Product(){}
}
