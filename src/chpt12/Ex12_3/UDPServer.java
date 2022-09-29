//UDPServer.java
package chpt12.Ex12_3;
import java.io.*;
import java.net.*;
import java.util.*;

public class UDPServer {  
	public UDPServer()throws IOException{
		
        String str_send = "Hi, I got it!";  
        byte[] buf = new byte[512];  
       
        DatagramSocket ds = new DatagramSocket(3000); //创建DatatgramSocke对象并在3000端口监听           
        DatagramPacket dpRec = new DatagramPacket(buf,512);//创建接收数据的DatagramPacket对象
        System.out.println("server is ready......");  
        boolean listening = true;
        while(listening){    
            ds.receive(dpRec);  //接收来自客户端的数据
            System.out.println("server got msg from client："); 
            String sData=new String(dpRec.getData(),0,dpRec.getLength());
            String cAddress= dpRec.getAddress().getHostAddress();
            int port=dpRec.getPort();
            System.out.println("server got msg from client："+cAddress+":" +port+"is:"+sData);  
            //创建发送回复的DatagramPacket对象，指定发送给端口号为9000的客户
            DatagramPacket dpAck= new DatagramPacket(str_send.getBytes(),str_send.length(),dpRec.getAddress(),9000);  
            ds.send(dpAck);  
            dpRec.setLength(512);  //重置长度为512
        }  
        ds.close();  
   } 
	public static void main(String[] args)throws IOException{  
		new UDPServer();
	}
}  