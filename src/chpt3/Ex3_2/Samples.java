//PassArg.java
package chpt3.Ex3_2;
public class Samples {
	
    void changeValue(int len)
	{
		len += len;
		System.out.println("inside changeValuemethod, length value is:"+len);
	}
    
    void changeName(Product ss)
	{
    	ss.name = "superIPad";
		System.out.println("inside changePrice method, Product name is:"+ss.name);
	}	
    
	public static void main(String[] args) 
	{		
		int length =10;
		Product ipad = new Product(10,"ipad2","computer",5000);
		Samples obj = new Samples();
	
		System.out.println("before change value,length is:"+length);
		obj.changeValue(length);
		System.out.println("after change value,length still is:"+length);
			
		System.out.println("before changing name,product name:"+ipad.name);
		obj.changeName(ipad);
		System.out.println("after changing name,product name has been changed to:"+ipad.name);
	}
}
