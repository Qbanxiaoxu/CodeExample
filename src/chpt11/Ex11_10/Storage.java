//Storage.java 
package chpt11.Ex11_10;
class Storage {     
    Product[] products = new Product[10];   
    int top = 0;   
   
    // ���������ֿ��з����Ʒ    
    public void push(Product product) { 
    synchronized (this){
        //�Ѳ�Ʒ����ֿ� 
        products[top++] = product; 
        System.out.println(Thread.currentThread().getName() + " creates "   
                + product);   
    }
  }   
    // �����ߴӲֿ���ȡ����Ʒ    
    public void pop() { 
    	synchronized(this){  
        //�Ӳֿ���ȡ��Ʒ  
        --top;   
        Product p = new Product(products[top].id, products[top].name);   
        products[top] = null;   
        System.out.println(Thread.currentThread().getName() + " buy" + p); 
       
    } 
   }
}   
