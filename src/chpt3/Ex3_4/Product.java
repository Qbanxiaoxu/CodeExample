//Product.java
package chpt3.Ex3_4;
public class Product {
     int ID;
     String name;
     String categories; 
     double productPrice;
     static double totalPrice; //
  	 static int totalNumber;   //��Ʒ����

     Product(int id, String nm, String categ,double price)
     {
    	 ID =id;
    	 name=nm;
    	 categories = categ;
    	 productPrice = price;
    	 totalPrice=totalPrice+productPrice; //�����ܼ۸�
 		 totalNumber++; //����һ��product����totalNumber����1   	 
     }
    Product(){}
    
    public String toString(){
    	return ("Product "+ ID+","+ name + ","+categories+","+productPrice);
    }
}
