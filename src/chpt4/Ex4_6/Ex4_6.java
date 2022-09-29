package chpt4.Ex4_6;
//Ex4_6.java
import java.io.*;

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
public class Ex4_6{
	 public static void main (String args[])throws NumberFormatException,IOException {  //在main里抛出异常
    		Product ipad = new Product();
    		boolean valid = false;
    		   		 
    		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    		
    		System.out.println("请输入 product ID:" );
    		ipad.ID =Integer.parseInt(in.readLine());
    				 
    	    System.out.println("请输入 product name:" );
    		ipad.name =in.readLine();
    			
    		System.out.println("请输入 product categoriese:" );
    		ipad.categories=in.readLine();
	 		
	 }	
}
