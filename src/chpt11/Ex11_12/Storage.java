//Storage.java 
package chpt11.Ex11_12;

import java.util.concurrent.locks.*;
class Storage {     
    Product[] products = new Product[10];   
    int top = 0;   
    Lock mylock = new ReentrantLock();//定义一个lock
    Condition full = mylock.newCondition(); //定义一个full的阻塞条件
    Condition empty = mylock.newCondition();//定义一个empty的阻塞条件
    // 生产者往仓库中放入产品    
    public void push(Product product) { 
    	mylock.lock(); //获取锁
    	 try { 
    		 	while (top == products.length) { 
    		 		System.out.println("storage is full,producer is waiting...");
    		 		full.await();//仓库已满，producer在full条件下等待    
    		 	} 
    		 //仓库空的，把产品放入仓库 
    		 products[top++] = product; 
    		 System.out.println(Thread.currentThread().getName() + " creates "  + product);   
             empty.signal();//唤醒在empty条件下等待的consumer  
    	 }catch (InterruptedException e) {
    		 System.out.println("producer failed to wait");
             e.printStackTrace();     
         }finally{ 
        	 mylock.unlock(); //释放锁
       }
  }   
    // 消费者从仓库中取出产品    
    public void pop() { 
    	mylock.lock(); //获取锁
    	try {   
    			while (top == 0) {  
    				System.out.println("storage is empty,consumer is waiting...");
    				empty.await();//仓库空，consumer在empty条件下等待     
    			} 
    			//仓库满的，从仓库中取产品  
    			--top;   
    			Product p = new Product(products[top].id, products[top].name);   
    			products[top] = null;   
    			System.out.println(Thread.currentThread().getName() + " buy" + p);   
    			full.signal();//唤醒在full条件下等待的Producer线程 
    	 } catch (InterruptedException e) { 
    		    System.out.println("consumer failed to wait");
             	e.printStackTrace();   
         } finally{  
        	 mylock.unlock(); //释放锁 
         }
	}
}   
