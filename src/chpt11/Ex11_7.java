package chpt11;

//Ex11_7.java
class JoinThread extends Thread{   
        public void run(){
        	    for(int i=0; i<5; i++)
                System.out.println("Joined thread is running"); 
        }
} 
public class Ex11_7{
    public static void main(String[] args){   
        System.out.println("In main thread...");
        JoinThread t=new JoinThread(); //创建一个JoinThread t          
         t.start();   
        try{   
            	System.out.println("joined status is: "+t.isAlive());   
            t.join();  // t加入到主线程中
            System.out.println("after join,joined thread exits");   
            System.out.println("joined thread status is: "+t.isAlive());   
                    
        }catch(java.lang.InterruptedException   ex){   
             System.out.println(ex);   
             System.out.println("joined thread is dead!");   
        } 
        System.out.println("main thread is still running");   
   }   
}   
