package chpt3;

//Ex3_12.java
public class Ex3_12{
	public static void main(String[] args){ 
        String str = "Welcome to Java"; 
        
        System.out.println(str + "���ַ�����Ϊ��" + str.length()); 
        
        System.out.println(str + "�е�5���ַ�Ϊ��" + str.charAt(5)); 
     
        System.out.println(str + "��'m'���ַ����ĵ�" + str.indexOf("m") + "λ"); 
        
        System.out.println(str + "��hello world����ͬ:" + str.equalsIgnoreCase("hello world")); 
       
        System.out.println(str + "�á�L���滻��l����Ϊ��" + str.replace("l", "L")); 
                
        System.out.println(str + "�ԡ�J����β:" + str.endsWith("J")); 
        
        System.out.println(str + "�ӵ�5���ַ���ʼ���Ӵ�Ϊ��" + str.substring(5)); 
        
        System.out.println("       Thanks      " + "ȥ����ͷ�ͽ�β�Ŀո�Ϊ:" + "       Thanks      ".trim()); 
    } 
}