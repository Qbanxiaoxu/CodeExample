//Product.java
package chpt3.Ex3_9;
public class Product {
     int ID;
     String name;
     String categories; 
     double productPrice;

     Product(int id, String nm, String categ,double price)
     {
    	 this.ID =id;   //thisָ��ָ���˵��ô˹��췽���Ķ���
    	 this.name=nm;
    	 this.categories = categ;
    	 this.productPrice = price;
     }
    Product(){
    	//thisָ����ô������Ĺ��췽��
    	this(2,"iphone","cellphone",3000);
		System.out.println("in Product()");

    }
}
