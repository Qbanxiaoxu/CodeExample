package chpt2;
//Ex2_11.java
import java.util.*;
public class Ex2_11 { 
  public static void main(String[] args) { 
	char arr[] =new char[15];//定义一个数组放置15个字母
	
    for(int i = 0; i < 15; i++) { 
    	//随机产生26个字母中的一个
      char c = (char)(Math.random() * 26 + 'a'); 
      System.out.print(c + ": ");      
      switch(c) { 
      case 'a': 
      case 'e': 
      case 'i': 
      case 'o': 
      case 'u': 
                System.out.println("元音"); 
                arr[i]=c;
                break; 
      case 'y': 
      case 'w': 
                System.out.println( "有时作为元音");
                arr[i]=c;
                break; 
      default: 
                System.out.println("辅音"); 
                arr[i]=c;    
      } //end of switch
    }//end of for
    Arrays.sort(arr);//对15个字母排序
    System.out.println("排序后的字母："+Arrays.toString(arr));        
  } 
} 
