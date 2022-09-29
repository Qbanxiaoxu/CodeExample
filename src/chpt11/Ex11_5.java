package chpt11;

//Ex11_5.java
public class Ex11_5 extends Thread{	
	private int x=0;
	public void run() {
		while (true) {
			System.out.println("I am running!");
			for (int i = 0; i < 900000; i++) {				
				 x=(int)(Math.random()*100);
			}
		}
	}		 
	public static void main(String[] args) throws Exception
	{
		Thread thr = new Ex11_5();
		System.out.println( "starting thread..." );	
        thr.start();
        thr.sleep(3000);
        System.out.println( "try to interrupt thread..." );
        thr.interrupt();
        Thread.sleep(3000);  
	}
}

