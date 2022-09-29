package chpt11;

//Ex11_15.java cathedThreadPool
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
public class Ex11_15 {  
 public static void main(String[] args) {  
	//����һ���ɵ��ڴ�С���̳߳�
     ExecutorService pool = Executors.newCachedThreadPool();
     
     //����һ�����߳����е��̳߳�
     //ExecutorService pool = Executors. newSingleThreadExector();;
     //����һ�������ù̶��߳������̳߳�
     //ExecutorService pool = Executors.newFixedThreadPool(5);
     //����һ�������ù̶��߳������̳߳�
     // ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

     //����5���߳�
     Thread t1 = new MyThread();
     Thread t2 = new MyThread();
     Thread t3 = new MyThread();
     Thread t4 = new MyThread();
     Thread t5 = new MyThread();
     
     //���̷߳�����н���ִ��
     pool.execute(t1);
     pool.execute(t2);
     pool.execute(t3);
     pool.execute(t4);
     pool.execute(t5);
     
     //�ر��̳߳�
     pool.shutdown();
 }
}  

class MyThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is running");
    }
}
