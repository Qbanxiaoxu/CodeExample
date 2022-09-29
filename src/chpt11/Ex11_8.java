package chpt11;

//Ex11_8.java
public class Ex11_8
{
	public static void main(String[] args)
	{
		Casher t=new Casher();   //　
		new Thread(t).start();      //创建３个Casher线程
		new Thread(t).start();
		new Thread(t).start();
	}
}
class Casher implements Runnable
{
	int customer = 500;   //将共享的资源
	public void run()
	{
		while(customer>0)   //还有顾客
		{
			System.out.println(Thread.currentThread().getName()
			+"is still open"+ customer--);
		}
	}
}
