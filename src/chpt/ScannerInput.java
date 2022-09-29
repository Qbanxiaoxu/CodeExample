//BufferReader的readLine(),Scanner的next系列，next()，nextInt()，nextDouble()只读取输入的字符，不读回车，回车会遗留在缓冲区
//而Scanner的nextLine(),会吃掉缓冲区内回车，使用时谨慎！如同C里的gets()
//C里的scanf()对输入长度没有限制，并且保留回车在缓存区，不安全
import java.util.*;
public class ScannerInput {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("please input your age:");
		int age = input.nextInt();
		
		System.out.println("please input your initial:");
		String init= input.next();
		
		//nextLine()输入带空格字符串之前吃掉回车
		//input.nextLine();
		System.out.println("please input your name:");
		String name = input.nextLine();
		
		System.out.println("please input your studentID:");
	    int stuID = input.nextInt();
 
	}

}
