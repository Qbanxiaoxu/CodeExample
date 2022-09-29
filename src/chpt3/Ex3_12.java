package chpt3;

//Ex3_12.java
public class Ex3_12{
	public static void main(String[] args){ 
        String str = "Welcome to Java"; 
        
        System.out.println(str + "的字符长度为：" + str.length()); 
        
        System.out.println(str + "中第5个字符为：" + str.charAt(5)); 
     
        System.out.println(str + "中'm'在字符串的第" + str.indexOf("m") + "位"); 
        
        System.out.println(str + "与hello world不相同:" + str.equalsIgnoreCase("hello world")); 
       
        System.out.println(str + "用‘L’替换‘l’后为：" + str.replace("l", "L")); 
                
        System.out.println(str + "以‘J’结尾:" + str.endsWith("J")); 
        
        System.out.println(str + "从第5个字符开始的子串为：" + str.substring(5)); 
        
        System.out.println("       Thanks      " + "去掉开头和结尾的空格为:" + "       Thanks      ".trim()); 
    } 
}