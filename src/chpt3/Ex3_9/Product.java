//Product.java
package chpt3.Ex3_9;
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
    Product(){
    	//this指针调用带参数的构造方法
    	this(2,"iphone","cellphone",3000);
		System.out.println("in Product()");

    }
}
