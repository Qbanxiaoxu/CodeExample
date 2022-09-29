package chpt4;

//Ex4_3.java
import java.io.*;
public class Ex4_3 {
	public static void main (String args[ ]) {
  	int a[]=new int[5];
	try{	
		a[6]=5;
	}
	catch(ArrayIndexOutOfBoundsException e){
		   System.out.println("数组下标越界");
	}
}
}
