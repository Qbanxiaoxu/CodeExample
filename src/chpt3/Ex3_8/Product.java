//Product.java
package chpt3.Ex3_8;
public class Product {
     int ID;
     String name;
     String categories; 
     double productPrice;
     int i = 0;
     
  	Product increment() {
     		i++;
    		return this;
   	}
   	void print() {
     		System.out.println("i = " + i);
   	}
    Product(int id, String nm, String categ,double price)
    {
    	 this.ID =id;    //thisָ��ָ���˵��ô˹��췽���Ķ���
    	 this.name=nm;
    	 this.categories = categ;
    	 this.productPrice = price;
     }
    Product(){}
}
