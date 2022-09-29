//UDPClient.java
package chpt12.Ex12_3;
import java.io.*;
import java.net.*;
import java.util.*;

public class UDPClient {  
	
	int TimeOut;  //���ý������ݵĳ�ʱʱ��     
    int MaxNum;      //�����ط����ݵ�������  
	String str_send;
	
	public UDPClient() throws IOException{
		TimeOut=5000; //��ʱ����Ϊ5��
		MaxNum=5;
		int tries = 0;            //�ط����ݵĴ���  
        boolean receivedOK = false;     //�������ݳɹ��ı�ʶ��	
		byte[] buf = new byte[512];
		
		DatagramSocket ds = new DatagramSocket(9000);//����DatagramSocket���󣬲��󶨶˿�9000  
        InetAddress loc = InetAddress.getLocalHost(); 
        
      //������׼����BufferedReader����
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Client input:");
        String line=stdin.readLine(); //�Ӽ��̶����ַ���
        
        //�������ڷ������ݵ�DatagramPacket���� ��ָ�����շŵĶ˿ں�3000
        DatagramPacket dpSend= new DatagramPacket(line.getBytes(),line.length(),loc,3000);  
        
        //���������������ݵ�DatagramPacket����  
        DatagramPacket dpReceive = new DatagramPacket(buf, 512); 
        
        ds.setSoTimeout(TimeOut);  // ���ý�������ʱ�������ʱ��  
        
        	while(!receivedOK && tries<MaxNum){ 
        		ds.send(dpSend);  //�������� 
        		try{  
                    //��9000�˿ڽ��մӷ���˷��ͻ���������  
                    ds.receive(dpReceive);  
                    receivedOK = true;  //���ý��ձ�ʶ��Ϊtrue
                }catch(InterruptedIOException e){  
                    //�ظ����ݽ��ճ�ʱ���ط�
                    tries += 1;  
                    System.out.println("No response,Time out," + (MaxNum - tries) + " more tries..." );  
                }  
            }  //end of while
        	if(receivedOK){  
        		System.out.println("response from server��"); 
        		String data= new String(dpReceive.getData(),0,dpReceive.getLength()); //��ȡ���յ�������
        		String fromAddress = dpReceive.getAddress().getHostAddress();
        		int port=dpReceive.getPort();
        		
        		System.out.println("received msg from "+fromAddress+":" +port+"is:"+data);      		      		
        		dpReceive.setLength(512); //���� dpReceive
        	}else{  
        		//����ط�MaxNum�����ݺ���δ��÷��������ͻ��������ݣ����ӡ������Ϣ  
        		System.out.println("No response -- quit!");  
        	}
        	ds.close();
    }              	
    public static void main(String args[])throws IOException{
    	new UDPClient();      
    }    
}   