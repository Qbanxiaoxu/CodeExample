//Storage.java
package chpt11.Ex11_9; 
class Storage {     
    Product[] products = new Product[10];   
    int top = 0;   
   
    // ���������ֿ��з����Ʒ    
    public synchronized void push(Product product) {   
        //�Ѳ�Ʒ����ֿ� 
        products[top++] = product; 
        System.out.println(Thread.currentThread().getName() + " creates "   
                + product);   
    }   
   
    // �����ߴӲֿ���ȡ����Ʒ    
    public synchronized Product pop() {     
        //�Ӳֿ���ȡ��Ʒ  	
    		--top;   
    		Product p = new Product(products[top].id, products[top].name);   
    		products[top] = null;   
    		System.out.println(Thread.currentThread().getName() + " buy" + p); 
    		return p; 
    }   
}   
