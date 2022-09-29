package chpt11;

//Ex11_15.java cathedThreadPool
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
public class Ex11_15 {  
 public static void main(String[] args) {  
	//创建一个可调节大小的线程池
     ExecutorService pool = Executors.newCachedThreadPool();
     
     //创建一个单线程运行的线程池
     //ExecutorService pool = Executors. newSingleThreadExector();;
     //创建一个可重用固定线程数的线程池
     //ExecutorService pool = Executors.newFixedThreadPool(5);
     //创建一个可重用固定线程数的线程池
     // ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

     //创建5个线程
     Thread t1 = new MyThread();
     Thread t2 = new MyThread();
     Thread t3 = new MyThread();
     Thread t4 = new MyThread();
     Thread t5 = new MyThread();
     
     //将线程放入池中进行执行
     pool.execute(t1);
     pool.execute(t2);
     pool.execute(t3);
     pool.execute(t4);
     pool.execute(t5);
     
     //关闭线程池
     pool.shutdown();
 }
}  

class MyThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is running");
    }
}
