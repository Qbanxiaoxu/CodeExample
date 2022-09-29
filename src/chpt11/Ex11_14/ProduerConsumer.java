//ProduerConsumer.java
package chpt11.Ex11_14;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProduerConsumer {

	public static void main(String[] args) {
		//创建一个LinkedBlockingQueue
		BlockingQueue<Product> queue = new LinkedBlockingQueue<Product>();	
		
		//创建Consumer对象和Producer对象
		Consumer consumer = new Consumer(queue);
		Producer producer = new Producer(queue);
		
		//创建5个Consumer线程和5个Producer线程
		for (int i = 0; i < 5; i++) {
			new Thread(producer, "Producer" + (i + 1)).start();

			new Thread(consumer, "Consumer" + (i + 1)).start();
		}
	}
}