//Product.java
package chpt3.Ex3_7;	
public class Product {
     int ID;
     String name;
     String categories; 
     double productPrice;

     Product(int id, String nm, String categ,double price)
     {
    	 this.ID =id;   //this指针指向了调用此构造方法的对象
    	 this.name=nm;
    	 this.categories = categ;
    	 this.productPrice = price;
     }
    Product(){}
}
