package chpt11.Ex11_3;

//Ex11_3.java Daemon thread
import java.io.IOException;
public class Ex11_3 extends Thread{
	public Ex11_3(){
		super.setDaemon(true);//ת��һ���û��߳�Ϊ�ػ��߳�
		start();
	}
	public void run(){
		while(true){
		System.out.println("I'm keeping running "+Thread.currentThread().getName());
		}
}
	public static void main(String[] args) throws InterruptedException, IOException {     
        new Ex11_3();  //����һ��Daemon����
        Thread.sleep(300);
	}
}
