//ProducersAndConsumers.java
package chpt11.Ex11_11;

public class ProducersAndConsumers {   
    public static void main(String[] args) {   
        Storage storage = new Storage();   
      
        Thread producer = new Thread(new Producer(storage));   
        producer.setName("producer"); 
        
        Thread consumer1 = new Thread(new Consumer(storage));   
        consumer1.setName("consumer1"); 
        
        Thread consumer2 = new Thread(new Consumer(storage));   
        consumer2.setName("consumer2");
    
       consumer1.start(); 
       consumer2.start();
       producer.start();          
    }   
}   
   
