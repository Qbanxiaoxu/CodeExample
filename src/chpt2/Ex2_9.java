package chpt2;
import java.io.*;
import java.util.*; 

public class Ex2_9 {
	public static void main(String[] args) throws   IOException   {
	       
		
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		//��һ��	integer������
		System.out.print("����ineger: ");   
        int anInt = Integer.parseInt(in.readLine());   
        System.out.println(anInt);   
  
        //��һ��float������   
        System.out.print("����float:   ");   
        float aFloat = Float.parseFloat(in.readLine());   
        System.out.println(aFloat);   
  
        // ��һ��double������      
        System.out.print("����double:   ");   
        double aDouble = Double.parseDouble(in.readLine());   
        System.out.println(aDouble);   
        
        // ��һ���ַ���
        System.out.print("����string:   ");
        String aString = in.readLine();
        System.out.println(aString);
	}      
}

		
