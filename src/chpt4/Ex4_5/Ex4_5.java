package chpt4.Ex4_5;
//Ex4_5.java
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
public class Ex4_5{
	 public static void main (String args[]) {
    		Product ipad = new Product();
    		boolean valid = false;
    		
    		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    		while(!valid){
    			try{
    				System.out.println("请输入 product ID:" );
    				ipad.ID =Integer.parseInt(in.readLine());
    				valid=true;
    			}catch(NumberFormatException e){System.out.println("ID 输入有误,必须输入数字，请再输入一次");}
    			catch(IOException e){
    				e.printStackTrace();
    				System.out.println("标准输入ID有误");
    			}
    		}		
    		try{
    			System.out.println("请输入 product name:" );
    				ipad.name =in.readLine();
    		}catch(IOException e){
    			e.printStackTrace();
    			System.out.println("标准输入product name 输入有误 ");
	 		}
    		try{
    			 System.out.println("请输入 product categoriese:" );
    			 ipad.categories=in.readLine();
    		}
    		catch(IOException e){
    			e.printStackTrace();
    			System.out.println("标准输入product categoriese 输入有误 ");
	 		}   			
	 }	
}
