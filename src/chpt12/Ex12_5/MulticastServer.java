//MultiUDPServer.java
package chpt12.Ex12_5;
import java.io.IOException;  
import java.net.DatagramPacket;  
import java.net.InetAddress;  
import java.net.MulticastSocket;

public class MulticastServer
{
    public static void main(String[] args)
    {        
        try{
        	InetAddress group = InetAddress.getByName("224.0.0.5");
        	DatagramPacket recvPack = new DatagramPacket(new byte[1024], 1024);
        	MulticastSocket socket = new MulticastSocket(8888);
 
        	socket.joinGroup(group);//加入组播后，socket发送的数据报可以被其他加入组播的成员收到
        	System.out.println("Server is ready......");
        	boolean listening = true;
            while(listening){   
        		socket.receive(recvPack);
        		String sData=new String(recvPack.getData(),0,recvPack.getLength());
        		String cAddress= recvPack.getAddress().getHostAddress();
        		int port=recvPack.getPort();
        		System.out.println("server got msg from client："+cAddress+":" +port+"is:"+sData);  
        	}
        	socket.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
 