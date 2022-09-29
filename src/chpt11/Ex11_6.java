package chpt11;

//Ex11_6.java
class ThreadInterrupt extends Thread
{
	public void run()
	{
		try
		{
			sleep(30000); // 延迟30秒
		}
		catch (InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
public class Ex11_6{	
	public static void main(String[] args) throws Exception
	{
		Thread thr = new ThreadInterrupt();
		thr.start();
		System.out.println("请30秒之内按任意键中断线程!");
		System.in.read();//获取输入
		thr.interrupt();
		System.out.println("线程退出运行!");
	}
}

