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
			Product temp = queue.take();//取出产品，如果队列为空，会阻塞当前线程
			System.out.println("I took out"+temp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}