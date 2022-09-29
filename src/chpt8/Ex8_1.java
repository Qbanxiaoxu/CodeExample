package chpt8;

//Ex8_1.java
import java.io.*;
import java.util.Scanner;

public class Ex8_1 {

    public static void main(String[] a)throws IOException {
    	//从键盘读入并输出到屏幕
        int age; 
        String name;
        
        System.out.println("please enter your age:");
        Scanner sc = new Scanner(System.in);
        age = sc.nextInt();
       
        System.out.println("please enter your name:");          
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        while((name = in.readLine()).length() != 0)
                 System.out.println("Your name is: "+name); 
        System.out.printf("Your age is: %d \n", age );
        
        //格式化输出
        System.out.printf("Pi is %7.3f \n", Math.PI);
        //输出当前系统日期及时间
        java.util.Calendar c = java.util.Calendar.getInstance();
        System.out.printf("%tD, %tT \n", c, c );
        System.out.printf("%1$tB %1$te, %1$tY \n", c);
       
        System.out.printf("%(d \n", -23);
        System.out.printf("**%2d**  \n", 0);
        
        String printableDate = String.format("%1$tB %1$te, %1$tY \n",java.util.Calendar.getInstance());        
        System.out.printf(printableDate);       
    }

}

