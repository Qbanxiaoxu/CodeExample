package chpt3;

public class Ex3_11
{ public static void main(String[] args)
   {
	String str = new String("Hello! ");
	String[] anArray =
         { "welcome ", "to ", "java"};
	double pi= 3.1415926;
    	  str = str+anArray[0]+anArray[1]+anArray[2];
    	  System.out.println(str.toUpperCase()); 
    	String str1 = anArray[0]+3+pi;
    	System.out.println(str1); 	
   }
}
