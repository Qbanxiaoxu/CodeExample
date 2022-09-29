//ProducersAndConsumers.java
package chpt11.Ex11_9;

public class ProducersAndConsumers {   
    public static void main(String[] args) {   
        Storage storage = new Storage();   
        
        Thread producer = new Thread(new Producer(storage));   
        producer.setName("producer"); 
             
        Thread consumer = new Thread(new Consumer(storage));   
        consumer.setName("consumer");  
        
        producer.start(); 
        consumer.start();   
    }   
}   
   
