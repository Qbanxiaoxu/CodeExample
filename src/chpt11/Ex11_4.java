package chpt11;

//Ex11_4.java
public class Ex11_4 extends Thread
{
	volatile boolean exit = false;

	public void run()
	{
		while (true){
			System.out.println("I'm running");
			if(exit== true)
				break;
		}
	}
	public static void main(String[] args) throws Exception
	{
        Ex11_4 thread = new Ex11_4();
        thread.start();
        sleep(2000); // ���߳��ӳ�2��
        thread.exit = true; // ��ֹ�߳�thread
        System.out.println("�߳��˳�!");
 }
}

