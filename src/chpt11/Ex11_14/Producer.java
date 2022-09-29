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
         	
         	queue.put(item1);//�����Ʒ��������������Ļ�����������ǰ�߳�   
         	System.out.println("I put in a product:"+item1);
         
      } catch (InterruptedException e) {   
          e.printStackTrace();   
      	}   
    }      
 }   
