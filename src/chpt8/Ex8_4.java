package chpt8;
//Ex8_4.java
import java.io.*;
class Ex8_4 {
    public static void main(String[] args)throws IOException {
        String fileName = "C:\\myjava\\code\\Hello.txt";       
        char[] buff = new char[256];// ����������������ÿ�ζ�ȡ�����ַ�
        int n;// ÿ�ζ�ȡ�����ַ����� 
        
        FileReader fr=new FileReader(fileName);   
        while ((n= fr.read(buff)) != -1) {//��ȡ����ַ����浽������
        	  for (int i = 0; i < n; i++) {
        		  System.out.print(buff[i]); //�����ȡ���ַ�
        	  }
        }      
        fr.close();    
    }
}

