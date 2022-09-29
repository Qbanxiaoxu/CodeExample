//Product.java
package chpt3.Ex3_4;
public class Product {
     int ID;
     String name;
     String categories; 
     double productPrice;
     static double totalPrice; //
  	 static int totalNumber;   //产品总数

     Product(int id, String nm, String categ,double price)
     {
    	 ID =id;
    	 name=nm;
    	 categories = categ;
    	 productPrice = price;
    	 totalPrice=totalPrice+productPrice; //计算总价格
 		 totalNumber++; //创建一个product对象，totalNumber增加1   	 
     }
    Product(){}
    
    public String toString(){
    	return ("Product "+ ID+","+ name + ","+categories+","+productPrice);
    }
}
