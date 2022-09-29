package chpt11;

//Ex11_6.java
class ThreadInterrupt extends Thread
{
	public void run()
	{
		try
		{
			sleep(30000); // �ӳ�30��
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
		System.out.println("��30��֮�ڰ�������ж��߳�!");
		System.in.read();//��ȡ����
		thr.interrupt();
		System.out.println("�߳��˳�����!");
	}
}

