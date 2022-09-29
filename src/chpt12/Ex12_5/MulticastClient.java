//MulticastClient.java
package chpt12.Ex12_5;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
 
public class MulticastClient
{
    public static void main(String[] args) throws IOException
    {       
        String msg = "hi,server";
        InetAddress group = InetAddress.getByName("224.0.0.5");
        MulticastSocket client = new MulticastSocket();//创建MulticastSocket对象
        DatagramPacket dpSend= new DatagramPacket(msg.getBytes(),msg.length(),group,8888);  
        //如果是发送数据报包,可以选择不加入多播组; 如果是接收数据报包,必须加入多播组
        client.joinGroup(group);
        client.send(dpSend);
        System.out.println("Client send msg complete");
        client.close();
    }
}

 


