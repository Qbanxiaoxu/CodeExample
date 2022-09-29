//Storage.java 
package chpt11.Ex11_11;

class Storage {     
    Product[] products = new Product[10];   
    static int top;   
   
    // ���������ֿ��з����Ʒ    
    public synchronized void push(Product product) {   
      while (top == products.length) {   
            try {  
            	System.out.println("storage is full,producer is waiting...");
                wait();//�ֿ��������ȴ�    
            } catch (InterruptedException e) { 
            	System.out.println("producer failed to wait");
                e.printStackTrace();   
            }   
        } 
        //�Ѳ�Ʒ����ֿ� 	
        products[top++] = product; 
        System.out.println(Thread.currentThread().getName() + " creates "   
                + product);   
        notify();//���ѵȴ��߳�    
   
    }   
   
    // �����ߴӲֿ���ȡ����Ʒ    
    public synchronized void pop() {   
       while (top == 0) {   
            try {  
            	System.out.println("storage is empty,consumer is waiting...");
                wait();//�ֿ�գ��ȴ�    
            } catch (InterruptedException e) { 
            	System.out.println("consumer failed to wait");
                e.printStackTrace();   
            }   
        } 
   
        //�Ӳֿ���ȡ��Ʒ  
        --top;
        Product p = new Product(products[top].id, products[top].name);   
        products[top] = null;   
        System.out.println(Thread.currentThread().getName() + " buys" + p);   
        notify();//���ѵȴ��߳�   
    }   
}   
