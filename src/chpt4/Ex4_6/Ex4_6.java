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
	 public static void main (String args[])throws NumberFormatException,IOException {  //��main���׳��쳣
    		Product ipad = new Product();
    		boolean valid = false;
    		   		 
    		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    		
    		System.out.println("������ product ID:" );
    		ipad.ID =Integer.parseInt(in.readLine());
    				 
    	    System.out.println("������ product name:" );
    		ipad.name =in.readLine();
    			
    		System.out.println("������ product categoriese:" );
    		ipad.categories=in.readLine();
	 		
	 }	
}
