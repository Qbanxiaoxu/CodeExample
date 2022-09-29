//Consumer.java
package chpt11.Ex11_10;
class Consumer implements Runnable {   
    Storage storage; 
    
    public Consumer(Storage storage) {   
        this.storage = storage;   
    }   
    public void run() { 
    	//consumer»√Producerœ»‘À––
   	 	try {  
            Thread.sleep(500);  
   	 	} catch (InterruptedException e) {  
   	 		e.printStackTrace();  
   	 	} 
    	for(int i=0;i<storage.products.length;i++)
    	{
    		storage.pop();
    		
    	}
    }   
}   
   
