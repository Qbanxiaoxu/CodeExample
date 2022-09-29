//Producer.java
package chpt11.Ex11_10;
class Producer implements Runnable {   
    private Storage storage; 
    
    public Producer(Storage storage) {   
        this.storage = storage;   
    }   
    public void run() {   
        for(int i=0;i<storage.products.length;i++)  
        {
        	Product product=new Product(i,"IPad");       
        	storage.push(product); 
        }
    }    
}   
   
