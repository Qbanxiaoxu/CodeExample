//TCPServer.java
package chpt12.Ex12_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	ServerSocket ss;
	Socket cs;
    public TCPServer() {
    	try{ 
    		try {
        	  ss = new ServerSocket(6666); //����һ��ServerSocket�����ڶ˿�6666
    		}catch(IOException e){
    			System.err.println("Failed to creat Socket");
    			System.exit(1);
    		}
    		System.out.println("Server is ready...");
    		try{
        	  cs = ss.accept(); //������accept()������ʱ׼����������һ��Client�����󣬷���һ��Socket����    	 
    		}catch (IOException e) {
    			System.err.println("Accept failed.");
    			System.exit(1);
    		}
    		System.out.println("Server is receiving msg from "+ss.getInetAddress()+":"+cs.getPort());
         
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
        	
        	while(!user.equals("bye")){//���������ַ�����Ϊ "bye"����ֹͣѭ��			
				os.println(user);//��ͻ�������ַ���			
				os.flush();//ˢ���������ʹClient�����յ����ַ���
				
				System.out.println("Msg from client is:"+is.readLine());//���ִ�Client����һ�ַ���������ӡ����׼�����
				
				System.out.print("Server input:");
				user=stdIn.readLine();//�Ӽ��̶����ַ�����Ϣ
				
			} //����ѭ��
            is.close(); //�ر�������
            os.close(); //�ر������
            cs.close(); //��һ���ͻ�ͨ����ϣ��ر�Client socket
            ss.close();//�ر�server socket
    	} catch (IOException ie) {
            ie.printStackTrace();
    	}     
}

    public static void main(String[] args) throws Exception {
        new TCPServer();
    }
}
