package chpt11;

//Ex11_8.java
public class Ex11_8
{
	public static void main(String[] args)
	{
		Casher t=new Casher();   //��
		new Thread(t).start();      //��������Casher�߳�
		new Thread(t).start();
		new Thread(t).start();
	}
}
class Casher implements Runnable
{
	int customer = 500;   //���������Դ
	public void run()
	{
		while(customer>0)   //���й˿�
		{
			System.out.println(Thread.currentThread().getName()
			+"is still open"+ customer--);
		}
	}
}
