package chpt3;

class Displaychar{

		//��ӡ45��*
		void repchar()
		   {
		   for(int j=0; j<45; j++)  // always loops 45 times
		      System.out.print( '*');         // always prints asterisk
		   	  System.out.println();  
		   }
		//--------------------------------------------------------------
		
		//��ӡ45��ָ���ַ�
		void repchar(char ch)
		   {
		   for(int j=0; j<45; j++)  // always loops 45 times
			   System.out.print(ch); // prints specified character
		   	   System.out.println(); 
		   }
		
		// d��ӡһ����Ŀ��ָ���ַ�
		void repchar(char ch, int n)
		   {
		   for(int j=0; j<n; j++)   // loops n times
			   System.out.print(ch);       // prints specified character
		   	   System.out.println(); 
		   }
}
public class Ex3_6{
	public static void main(String[] args){
		Displaychar dp = new Displaychar();
		dp.repchar();
		dp.repchar('#');
		dp.repchar('.', 30);
	}
}
