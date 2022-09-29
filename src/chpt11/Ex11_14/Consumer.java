//Consumer.java
package chpt11.Ex11_14;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	BlockingQueue<Product> queue;	
	public Consumer(BlockingQueue<Product> queue){
		this.queue = queue;
	}
	public void run() {
		try {
			Product temp = queue.take();//ȡ����Ʒ���������Ϊ�գ���������ǰ�߳�
			System.out.println("I took out"+temp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}