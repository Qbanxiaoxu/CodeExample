//Storage.java 
package chpt11.Ex11_10;
class Storage {     
    Product[] products = new Product[10];   
    int top = 0;   
   
    // 生产者往仓库中放入产品    
    public void push(Product product) { 
    synchronized (this){
        //把产品放入仓库 
        products[top++] = product; 
        System.out.println(Thread.currentThread().getName() + " creates "   
                + product);   
    }
  }   
    // 消费者从仓库中取出产品    
    public void pop() { 
    	synchronized(this){  
        //从仓库中取产品  
        --top;   
        Product p = new Product(products[top].id, products[top].name);   
        products[top] = null;   
        System.out.println(Thread.currentThread().getName() + " buy" + p); 
       
    } 
   }
}   
