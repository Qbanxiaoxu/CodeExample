package chpt2;
//Ex2_11.java
import java.util.*;
public class Ex2_11 { 
  public static void main(String[] args) { 
	char arr[] =new char[15];//����һ���������15����ĸ
	
    for(int i = 0; i < 15; i++) { 
    	//�������26����ĸ�е�һ��
      char c = (char)(Math.random() * 26 + 'a'); 
      System.out.print(c + ": ");      
      switch(c) { 
      case 'a': 
      case 'e': 
      case 'i': 
      case 'o': 
      case 'u': 
                System.out.println("Ԫ��"); 
                arr[i]=c;
                break; 
      case 'y': 
      case 'w': 
                System.out.println( "��ʱ��ΪԪ��");
                arr[i]=c;
                break; 
      default: 
                System.out.println("����"); 
                arr[i]=c;    
      } //end of switch
    }//end of for
    Arrays.sort(arr);//��15����ĸ����
    System.out.println("��������ĸ��"+Arrays.toString(arr));        
  } 
} 
