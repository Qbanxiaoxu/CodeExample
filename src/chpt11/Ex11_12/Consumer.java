//Consumer.java
package chpt11.Ex11_12;

class Consumer implements Runnable {   
    Storage storage; 
   
    public Consumer(Storage storage) {   
        this.storage = storage;  
    }      
    public void run() {
    	for(int i=0; i<storage.products.length;i++)
    	{
    		storage.pop(); 
    	}   	

    }   
}   
   
