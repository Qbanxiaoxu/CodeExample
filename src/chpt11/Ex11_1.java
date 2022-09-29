package chpt11;

public class Ex11_1 {
   public static void main(String[] a) {
      Lamb thr1 = new Lamb();//创建 新线程thr1
      thr1.start(); //thr1启动
      Wolf thr2 = new Wolf();
      thr2.start();
      //主线程仍在运行
      for(int i = 0; i<3; i++){
    	  System.out.println("main thread is running: ");
      }
   }
}

class Lamb extends Thread {
   public void run() {
	   for(int i = 0; i<3; i++){
             System.out.println("I'm a happy lamb");
         }
   }
}

class Wolf extends Thread {
   public void run() {
	   for(int i = 0; i<3; i++){
             System.out.println("I'm big bad grey wolf");
            
         }
   }
}
