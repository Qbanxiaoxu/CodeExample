//Product.java
package chpt5.Ex5_1;
public class Product {
     protected int ID;
     protected String name;
     protected String categories;
     protected double ProductPrice;

     int getID(){
        return ID;
     }
     String getName(){
        return name;
     }
     String getCategories(){
        return categories;
     }
     double getPrice(){
        return ProductPrice;
     }   
}
