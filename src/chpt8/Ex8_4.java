package chpt8;
//Ex8_4.java
import java.io.*;
class Ex8_4 {
    public static void main(String[] args)throws IOException {
        String fileName = "C:\\myjava\\code\\Hello.txt";       
        char[] buff = new char[256];// 定义数组用来保存每次读取到的字符
        int n;// 每次读取到的字符长度 
        
        FileReader fr=new FileReader(fileName);   
        while ((n= fr.read(buff)) != -1) {//读取多个字符保存到数组中
        	  for (int i = 0; i < n; i++) {
        		  System.out.print(buff[i]); //输出读取的字符
        	  }
        }      
        fr.close();    
    }
}

