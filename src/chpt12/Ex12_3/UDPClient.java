//UDPClient.java
package chpt12.Ex12_3;
import java.io.*;
import java.net.*;
import java.util.*;

public class UDPClient {  
	
	int TimeOut;  //设置接收数据的超时时间     
    int MaxNum;      //设置重发数据的最多次数  
	String str_send;
	
	public UDPClient() throws IOException{
		TimeOut=5000; //超时设置为5秒
		MaxNum=5;
		int tries = 0;            //重发数据的次数  
        boolean receivedOK = false;     //接收数据成功的标识符	
		byte[] buf = new byte[512];
		
		DatagramSocket ds = new DatagramSocket(9000);//创建DatagramSocket对象，并绑定端口9000  
        InetAddress loc = InetAddress.getLocalHost(); 
        
      //创建标准输入BufferedReader对象
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Client input:");
        String line=stdin.readLine(); //从键盘读入字符串
        
        //创建用于发送数据的DatagramPacket对象 ，指定接收放的端口号3000
        DatagramPacket dpSend= new DatagramPacket(line.getBytes(),line.length(),loc,3000);  
        
        //创建用来接收数据的DatagramPacket对象  
        DatagramPacket dpReceive = new DatagramPacket(buf, 512); 
        
        ds.setSoTimeout(TimeOut);  // 设置接收数据时阻塞的最长时间  
        
        	while(!receivedOK && tries<MaxNum){ 
        		ds.send(dpSend);  //发送数据 
        		try{  
                    //在9000端口接收从服务端发送回来的数据  
                    ds.receive(dpReceive);  
                    receivedOK = true;  //设置接收标识符为true
                }catch(InterruptedIOException e){  
                    //回复数据接收超时，重发
                    tries += 1;  
                    System.out.println("No response,Time out," + (MaxNum - tries) + " more tries..." );  
                }  
            }  //end of while
        	if(receivedOK){  
        		System.out.println("response from server："); 
        		String data= new String(dpReceive.getData(),0,dpReceive.getLength()); //获取接收到的数据
        		String fromAddress = dpReceive.getAddress().getHostAddress();
        		int port=dpReceive.getPort();
        		
        		System.out.println("received msg from "+fromAddress+":" +port+"is:"+data);      		      		
        		dpReceive.setLength(512); //重置 dpReceive
        	}else{  
        		//如果重发MaxNum次数据后，仍未获得服务器发送回来的数据，则打印如下信息  
        		System.out.println("No response -- quit!");  
        	}
        	ds.close();
    }              	
    public static void main(String args[])throws IOException{
    	new UDPClient();      
    }    
}   