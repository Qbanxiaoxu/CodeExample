package chpt4.Ex4_8;
class Product {
     int ID;
     String name;
     String categories;
     double ProductPrice;
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
class PriceException extends Exception {
	 public PriceException(){
	  System.out.println("the price is too low!!!");
	 }
	}
public class Ex4_8{
	 public static void main(String args[]) {
    		Product ipad = new Product();
    		ipad.ID =123;
    		ipad.name = "ipad2";
    		ipad.ProductPrice = 50;//Price<100
    		 try{
    			 if(ipad.ProductPrice<100)
    			   throw new PriceException();//抛出异常PriceException类对象
    		}catch(PriceException e)
    		{e.getMessage();}		
 } 		
}