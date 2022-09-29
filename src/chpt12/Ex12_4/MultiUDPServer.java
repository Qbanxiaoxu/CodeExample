//MultiUDPServer.java
package chpt12.Ex12_4;
import java.io.*;
import java.net.*;
import java.util.*;

public class MultiUDPServer {  	
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(4444);//����DatatgramSocke������4444�˿ڼ���           	
		int clientNum=0;
		System.out.println("server is ready......");

		boolean listening = true;
        while(listening){   
        	byte[] buf = new byte[512];
    		DatagramPacket dpRec = new DatagramPacket(buf, buf.length);//�����������ݵ�DatagramPacket����
            ds.receive(dpRec);  //�������Կͻ��˵�����           
            clientNum++;
            new UDPThread(ds, dpRec,clientNum).start();//����һ���̴߳���һ���ͻ�����         
        }
	}
}  	
class UDPThread extends Thread{
    DatagramSocket ds;
    DatagramPacket dp;
    int cliNum;
    
    public UDPThread(DatagramSocket socket, DatagramPacket packet,int clientNumber) {
        this.ds = socket;
        this.dp = packet;
        this.cliNum=clientNumber;
        System.out.println("Accept client"+cliNum); 
    }
    public void run(){    	
        String sData=new String(dp.getData(),0,dp.getLength());
        String cAddress= dp.getAddress().getHostAddress();
        int port=dp.getPort();
        System.out.println("server got msg from client��"+cAddress+":" +port+"is:"+sData);  
        String str_send = "Hi, client"+cliNum+" I got it!";
        
        //�������ͻظ���DatagramPacket����ָ�����͸��˿ں�Ϊ5555�Ŀͻ�
        DatagramPacket dpAck= new DatagramPacket(str_send.getBytes(),str_send.length(),dp.getAddress(),5555);  
        try {
			ds.send(dpAck);
		} catch (IOException e) {
			System.out.println("failed to send Ack to client" +cliNum);
			e.printStackTrace();
		} 
    }
}        
        
        
        
        
       

	