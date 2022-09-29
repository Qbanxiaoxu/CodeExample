//Storage.java 
package chpt11.Ex11_11;

class Storage {     
    Product[] products = new Product[10];   
    static int top;   
   
    // 生产者往仓库中放入产品    
    public synchronized void push(Product product) {   
      while (top == products.length) {   
            try {  
            	System.out.println("storage is full,producer is waiting...");
                wait();//仓库已满，等待    
            } catch (InterruptedException e) { 
            	System.out.println("producer failed to wait");
                e.printStackTrace();   
            }   
        } 
        //把产品放入仓库 	
        products[top++] = product; 
        System.out.println(Thread.currentThread().getName() + " creates "   
                + product);   
        notify();//唤醒等待线程    
   
    }   
   
    // 消费者从仓库中取出产品    
    public synchronized void pop() {   
       while (top == 0) {   
            try {  
            	System.out.println("storage is empty,consumer is waiting...");
                wait();//仓库空，等待    
            } catch (InterruptedException e) { 
            	System.out.println("consumer failed to wait");
                e.printStackTrace();   
            }   
        } 
   
        //从仓库中取产品  
        --top;
        Product p = new Product(products[top].id, products[top].name);   
        products[top] = null;   
        System.out.println(Thread.currentThread().getName() + " buys" + p);   
        notify();//唤醒等待线程   
    }   
}   
