//Product.java
package chpt6.Ex6_4;
abstract public class Product implements OnlineShopping{
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
    abstract void ads();   
}
