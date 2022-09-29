package chpt11.Ex11_2;
//Lamb继承与Thread类
class Lamb extends Thread {
    public void run() { 
    	for (int i=0;i<3;i++) 
    		System.out.println("I'm a happy lamb"); }
}
//Wolf实现了Runnable接口
class Wolf implements Runnable {
    public void run() { 
    	for (int i=0;i<3;i++)
    		System.out.println("I'm a big bad grey wolf"); }
}



public class Ex11_2 {

    public static void main(String[] args) {
        Lamb xiyangyang = new Lamb();
        Wolf greywolf = new Wolf();
        Thread t1 = new Thread(greywolf);
        xiyangyang.start();
        t1.start();
        for (int i=0;i<3;i++)
        	System.out.println("main thread is running");
    }

}
