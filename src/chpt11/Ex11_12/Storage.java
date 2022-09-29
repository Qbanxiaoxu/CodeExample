//Storage.java 
package chpt11.Ex11_12;

import java.util.concurrent.locks.*;
class Storage {     
    Product[] products = new Product[10];   
    int top = 0;   
    Lock mylock = new ReentrantLock();//����һ��lock
    Condition full = mylock.newCondition(); //����һ��full����������
    Condition empty = mylock.newCondition();//����һ��empty����������
    // ���������ֿ��з����Ʒ    
    public void push(Product product) { 
    	mylock.lock(); //��ȡ��
    	 try { 
    		 	while (top == products.length) { 
    		 		System.out.println("storage is full,producer is waiting...");
    		 		full.await();//�ֿ�������producer��full�����µȴ�    
    		 	} 
    		 //�ֿ�յģ��Ѳ�Ʒ����ֿ� 
    		 products[top++] = product; 
    		 System.out.println(Thread.currentThread().getName() + " creates "  + product);   
             empty.signal();//������empty�����µȴ���consumer  
    	 }catch (InterruptedException e) {
    		 System.out.println("producer failed to wait");
             e.printStackTrace();     
         }finally{ 
        	 mylock.unlock(); //�ͷ���
       }
  }   
    // �����ߴӲֿ���ȡ����Ʒ    
    public void pop() { 
    	mylock.lock(); //��ȡ��
    	try {   
    			while (top == 0) {  
    				System.out.println("storage is empty,consumer is waiting...");
    				empty.await();//�ֿ�գ�consumer��empty�����µȴ�     
    			} 
    			//�ֿ����ģ��Ӳֿ���ȡ��Ʒ  
    			--top;   
    			Product p = new Product(products[top].id, products[top].name);   
    			products[top] = null;   
    			System.out.println(Thread.currentThread().getName() + " buy" + p);   
    			full.signal();//������full�����µȴ���Producer�߳� 
    	 } catch (InterruptedException e) { 
    		    System.out.println("consumer failed to wait");
             	e.printStackTrace();   
         } finally{  
        	 mylock.unlock(); //�ͷ��� 
         }
	}
}   
