package chpt11.Ex11_3;

//Ex11_3.java Daemon thread
import java.io.IOException;
public class Ex11_3 extends Thread{
	public Ex11_3(){
		super.setDaemon(true);//转换一个用户线程为守护线程
		start();
	}
	public void run(){
		while(true){
		System.out.println("I'm keeping running "+Thread.currentThread().getName());
		}
}
	public static void main(String[] args) throws InterruptedException, IOException {     
        new Ex11_3();  //创建一个Daemon对象
        Thread.sleep(300);
	}
}
