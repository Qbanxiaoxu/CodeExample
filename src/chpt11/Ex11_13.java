package chpt11;

//Ex11_13.java
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Ex11_13 {
 public static void main(String[] args) {
  readwriteOp one = new readwriteOp();

  for (int i=0; i < 3; i++) {
	 readThread thr = new readThread(one);
     writeThread thrw = new writeThread(one);   
     thr.start();
     thrw.start();
  }
 }
}
class readThread extends Thread{
	readwriteOp rw;
	public readThread(readwriteOp op){
		this.rw=op ;
	}
	public void run(){
		while(true){
			rw.reader();
		}
	}
}

class writeThread extends Thread{
	readwriteOp rw;
	public writeThread(readwriteOp op){
		this.rw=op ;
	}
	public void run(){
		while(true){
			//д��һ�������
		      rw.writer(new Random().nextInt(10000));
		}
	}
}
//�Թ������ݽ��ж�д��������
class readwriteOp{
 private int num;//��������
 private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();//������д��
 
 public void reader(){ 
	 rw1.readLock().lock();//�Ӷ���
	 System.out.println(Thread.currentThread().getName()+"is ready to read number");
	 try{
		 Thread.sleep((long) (Math.random()*1000));//����ͣ��
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	 System.out.println(Thread.currentThread().getName()+"have read number: " + num);
	 rw1.readLock().unlock(); //�ͷŶ���
 } 
 
 public void writer(int data){ 
	 rw1.writeLock().lock();//��д��
	 System.out.println(Thread.currentThread().getName()+" is ready to write number");
	 try{
		 Thread.sleep((long) (Math.random()*1000));
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	 this.num = data;
	 System.out.println(Thread.currentThread().getName()+"have write number: "+ num);
	 rw1.writeLock().unlock();
 }
}