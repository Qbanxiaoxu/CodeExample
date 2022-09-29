//UDPServer.java
package chpt12.Ex12_3;
import java.io.*;
import java.net.*;
import java.util.*;

public class UDPServer {  
	public UDPServer()throws IOException{
		
        String str_send = "Hi, I got it!";  
        byte[] buf = new byte[512];  
       
        DatagramSocket ds = new DatagramSocket(3000); //����DatatgramSocke������3000�˿ڼ���           
        DatagramPacket dpRec = new DatagramPacket(buf,512);//�����������ݵ�DatagramPacket����
        System.out.println("server is ready......");  
        boolean listening = true;
        while(listening){    
            ds.receive(dpRec);  //�������Կͻ��˵�����
            System.out.println("server got msg from client��"); 
            String sData=new String(dpRec.getData(),0,dpRec.getLength());
            String cAddress= dpRec.getAddress().getHostAddress();
            int port=dpRec.getPort();
            System.out.println("server got msg from client��"+cAddress+":" +port+"is:"+sData);  
            //�������ͻظ���DatagramPacket����ָ�����͸��˿ں�Ϊ9000�Ŀͻ�
            DatagramPacket dpAck= new DatagramPacket(str_send.getBytes(),str_send.length(),dpRec.getAddress(),9000);  
            ds.send(dpAck);  
            dpRec.setLength(512);  //���ó���Ϊ512
        }  
        ds.close();  
   } 
	public static void main(String[] args)throws IOException{  
		new UDPServer();
	}
}  