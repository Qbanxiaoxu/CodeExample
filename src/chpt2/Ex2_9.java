package chpt2;
import java.io.*;
import java.util.*; 

public class Ex2_9 {
	public static void main(String[] args) throws   IOException   {
	       
		
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		//读一个	integer型数字
		System.out.print("输入ineger: ");   
        int anInt = Integer.parseInt(in.readLine());   
        System.out.println(anInt);   
  
        //读一个float型数字   
        System.out.print("输入float:   ");   
        float aFloat = Float.parseFloat(in.readLine());   
        System.out.println(aFloat);   
  
        // 读一个double型数字      
        System.out.print("输入double:   ");   
        double aDouble = Double.parseDouble(in.readLine());   
        System.out.println(aDouble);   
        
        // 读一个字符串
        System.out.print("输入string:   ");
        String aString = in.readLine();
        System.out.println(aString);
	}      
}

		
