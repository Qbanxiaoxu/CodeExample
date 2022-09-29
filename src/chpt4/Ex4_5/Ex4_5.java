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
    				System.out.println("������ product ID:" );
    				ipad.ID =Integer.parseInt(in.readLine());
    				valid=true;
    			}catch(NumberFormatException e){System.out.println("ID ��������,�����������֣���������һ��");}
    			catch(IOException e){
    				e.printStackTrace();
    				System.out.println("��׼����ID����");
    			}
    		}		
    		try{
    			System.out.println("������ product name:" );
    				ipad.name =in.readLine();
    		}catch(IOException e){
    			e.printStackTrace();
    			System.out.println("��׼����product name �������� ");
	 		}
    		try{
    			 System.out.println("������ product categoriese:" );
    			 ipad.categories=in.readLine();
    		}
    		catch(IOException e){
    			e.printStackTrace();
    			System.out.println("��׼����product categoriese �������� ");
	 		}   			
	 }	
}
