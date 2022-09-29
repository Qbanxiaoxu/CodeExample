//Producer.java
package chpt11.Ex11_14;
import java.util.concurrent.BlockingQueue;   

 public class Producer implements Runnable {   
	 BlockingQueue<Product> queue; 
	    public Producer(BlockingQueue<Product> queue) {   
       this.queue = queue;   
  }    
    public void run() {   
      try {   
    	  Product item1 = new Product("111111", "IPad");    
         	System.out.println("I have made a product:"   + Thread.currentThread().getName());   
         	
         	queue.put(item1);//放入产品，如果队列是满的话，会阻塞当前线程   
         	System.out.println("I put in a product:"+item1);
         
      } catch (InterruptedException e) {   
          e.printStackTrace();   
      	}   
    }      
 }   
