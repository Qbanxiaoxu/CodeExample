package chpt3;

//Ex3_13.java
public class Ex3_13 {
	public static void main(String[] args) {
		String str1="Welcome to Java";
		StringBuffer sb1 = new StringBuffer();
		sb1.append(str1); 
		System.out.println("字符串sb1为："+sb1);
		System.out.println("字符串sb1的长度为"+sb1.length());
		System.out.println("字符串sb1的容量为"+sb1.capacity());
		
		sb1.setCharAt(2, 'E');//更改字符串中的字母
		System.out.println("修改后的字符串为："+sb1);
		
		sb1.reverse();
		System.out.println("reverse后的字符串为："+sb1);
		
		sb1.replace(0, 5, "hello");
		System.out.println("用hello替代后的字符串为："+sb1);
	}

}
