//MultiTCPServer.java
package chpt12.Ex12_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiTCPServer {
		ServerSocket ss;
		Socket cltsocket;
		int clientNum;
		
	public MultiTCPServer(){
		try {
        	  	 ss = new ServerSocket(6666); //����һ��Server Socket�����ڶ˿�6666 		
        	  	 System.out.println("Server is ready...");
		}catch(IOException e){
			System.err.println("Failed to creat Socket");
			System.exit(1);
		}
    	while(true){
    		try{
    			 cltsocket = ss.accept(); //������accept()��������Client������,����һ��Socket����
    		}catch (IOException e) {
    	    	System.err.println("Accept failed.");
    	    	System.exit(1);
    	    }
    		clientNum++;
    		//����b������һ���̴߳���һ��Client������
    		new MultiServerThread(cltsocket, clientNum).start();  
    	}//end of while
	}

    public static void main(String[] args) throws IOException{
    	new MultiTCPServer();
	}
}	
 //�߳�           
class MultiServerThread extends Thread
{	
	private Socket cs;
	private int cltNum;
	private ServerSocket ss;
	
	public MultiServerThread(Socket socket, int clientNumber)
    {
		this.cs=socket;
		this.cltNum=clientNumber;		
		System.out.println("Accepted Client��" + cltNum); 
    }
	public void run()
	{		
    	try{	        
    		//��Socket��������������������BufferedReader����
            InputStreamReader rs=new InputStreamReader(cs.getInputStream());//��������
            BufferedReader is=new BufferedReader(rs); 
          
            //��Socket�������������������PrintWriter����
            PrintWriter os = new PrintWriter(cs.getOutputStream(),true);
            
            //�������������BufferedReader����
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            
          //��Socket�ж�������Client�����ݲ��������Ļ
            String line = is.readLine();
            System.out.println("Client msg is:"+line);
            
            //�Ӽ��̶�����Ϣ   	
        	System.out.print("Server input:");
        	String user = stdIn.readLine();
        	
        	while(!user.equals("bye"))
        	{//���������ַ�����Ϊ "bye"����ֹͣѭ��			
				os.println(user);//��ͻ�������ַ���			
				os.flush();//ˢ���������ʹClient�����յ����ַ���
				
				//���ִ�Client����һ�ַ���������ӡ����׼�����				
				System.out.println("Msg from client is:"+is.readLine());
				System.out.print("Server input:");
				user=stdIn.readLine();//�Ӽ��̶����ַ�����Ϣ
				
			} //����ѭ��
            is.close(); //�ر�������
            os.close(); //�ر������
            cs.close(); //��һ���ͻ�ͨ����ϣ��ر�Client socket
    		}catch (IOException ie) {
    			ie.printStackTrace();
    		}
   }//end of run
}

 
