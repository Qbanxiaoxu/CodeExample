package chpt3;

//Ex3_13.java
public class Ex3_13 {
	public static void main(String[] args) {
		String str1="Welcome to Java";
		StringBuffer sb1 = new StringBuffer();
		sb1.append(str1); 
		System.out.println("�ַ���sb1Ϊ��"+sb1);
		System.out.println("�ַ���sb1�ĳ���Ϊ"+sb1.length());
		System.out.println("�ַ���sb1������Ϊ"+sb1.capacity());
		
		sb1.setCharAt(2, 'E');//�����ַ����е���ĸ
		System.out.println("�޸ĺ���ַ���Ϊ��"+sb1);
		
		sb1.reverse();
		System.out.println("reverse����ַ���Ϊ��"+sb1);
		
		sb1.replace(0, 5, "hello");
		System.out.println("��hello�������ַ���Ϊ��"+sb1);
	}

}
