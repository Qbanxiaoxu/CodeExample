//ProduerConsumer.java
package chpt11.Ex11_14;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProduerConsumer {

	public static void main(String[] args) {
		//����һ��LinkedBlockingQueue
		BlockingQueue<Product> queue = new LinkedBlockingQueue<Product>();	
		
		//����Consumer�����Producer����
		Consumer consumer = new Consumer(queue);
		Producer producer = new Producer(queue);
		
		//����5��Consumer�̺߳�5��Producer�߳�
		for (int i = 0; i < 5; i++) {
			new Thread(producer, "Producer" + (i + 1)).start();

			new Thread(consumer, "Consumer" + (i + 1)).start();
		}
	}
}