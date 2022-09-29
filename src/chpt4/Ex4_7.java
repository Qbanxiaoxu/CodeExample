package chpt4;

//Ex4_7.java
class Process{
	
	void Proc( int sel ) 
	{
		System.out.println("*****in case " + sel + " *****");
		if( sel==0 )    //û���쳣
		{
			System.out.println("no Exception caught");
			return;
		}
		else if( sel==1 ) 
		{
			try{		
				int i=0;
				int j=5/i; //����Ϊ��
				throw new ArithmeticException(); //��ʾ���׳��쳣ArithmeticException������
			} 
			catch(ArithmeticException e)
			{
				System.out.println( e.toString() );
			}
		}
		else if( sel==2 )
		{
			try{
				int iArray[]=new int[4];
				iArray[10]=5;      //����Խ��
				throw new ArrayIndexOutOfBoundsException(); //��ʾ���׳��쳣ArrayIndexOutOfBoundsExceptionn����
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println( e.toString() );
			}
		}
	}
}
public class Ex4_7{
	public static void main( String args[] )
	{
		Process pp = new Process();
		try
		{
			pp.Proc( 0 );   //����proc
			pp.Proc( 1 );
			pp.Proc( 2 );
		}catch( ArithmeticException e ){
			System.out.println("Catch: " + e + "; Reason: " + e.getMessage());
		}catch( ArrayIndexOutOfBoundsException e ){
			System.out.println("Catch: " + e + "; Reason: " + e.getMessage());
		}catch( Exception e ){
			System.out.println("Will not be executed");
		}finally{
			System.out.println("must go inside finally");}
	}

}
	
