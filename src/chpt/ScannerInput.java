//BufferReader��readLine(),Scanner��nextϵ�У�next()��nextInt()��nextDouble()ֻ��ȡ������ַ��������س����س��������ڻ�����
//��Scanner��nextLine(),��Ե��������ڻس���ʹ��ʱ��������ͬC���gets()
//C���scanf()�����볤��û�����ƣ����ұ����س��ڻ�����������ȫ
import java.util.*;
public class ScannerInput {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("please input your age:");
		int age = input.nextInt();
		
		System.out.println("please input your initial:");
		String init= input.next();
		
		//nextLine()������ո��ַ���֮ǰ�Ե��س�
		//input.nextLine();
		System.out.println("please input your name:");
		String name = input.nextLine();
		
		System.out.println("please input your studentID:");
	    int stuID = input.nextInt();
 
	}

}
