package chpt4.Ex4_4;
//Product.java
//Ex4_4.java
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
public class Ex4_4{
	public static void main(String args[]) {
    	Product ipad = new Product();   		
    	BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    		try{
    			 System.out.println("������ product ID:" );
    			 ipad.ID =Integer.parseInt(in.readLine());
    		 }catch(NumberFormatException e){
    			 System.out.println("ID ��������,������������ ");
    			 e.printStackTrace();
    			 System.exit(-1);
    		 } catch (IOException e) {
    			System.out.println("��׼��������");
				e.printStackTrace();
			}		
    		 System.out.println("������ product name:" );
    		 try {
				ipad.name =in.readLine();
			} catch (IOException e) {
				System.out.println("��׼����name����");
				e.printStackTrace();
			}
    		 
    		 System.out.println("������ product categories:" );
    		 try {
				ipad.categories=in.readLine();
			} catch (IOException e) {
				System.out.println("��׼����categories����");
				e.printStackTrace();
			}
	 }	
}