package chpt3;

public class Ex3_5
{
	static int sRec;
	static int vRec;
	
	static void area(int a,int b)
	{
		sRec=a*b;
	}
	static void volume(int a, int b, int c)
	{
		vRec=a*b*c;
	}
	public static void main(String args[])
	{
		area(4,6);
		volume(4,6,8);
		System.out.println("the rectangle area is: "+sRec);
		System.out.println("the rectangle volume is: "+vRec);
	}
}

