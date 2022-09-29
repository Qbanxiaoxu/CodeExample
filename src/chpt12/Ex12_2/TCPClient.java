package chpt12.Ex12_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	Socket cs;
	PrintWriter os;
    
    public TCPClient() {
      try{
        try{
        	 cs = new Socket("127.0.0.1",6666);//����һ��Client socket���󶨶˿ں�9999  
        	 os = new PrintWriter(cs.getOutputStream(),true);//�������
        }catch (UnknownHostException e) {
                System.err.println("Failed to get Server hostname");
                System.exit(1);
        } catch (IOException e) {
        	System.err.println("Failed to create socket");
            System.exit(1);
		}

      //��Socket�������������������PrintWriter����
		PrintWriter os=new PrintWriter(cs.getOutputStream());
		
		//��Socket��������������������BufferedReader����
		BufferedReader is=new BufferedReader(new InputStreamReader(cs.getInputStream()));
		
		//������׼����BufferedReader����
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Client input:");
        String line=stdin.readLine(); //�Ӽ��̶����ַ���
		
        while(!line.equals("bye")) {//�Ӽ��̶�����ַ�����Ϊ "bye"��ֹͣѭ��     
        	os.println(line);//���Ӽ��̶�����ַ��������Server 
        	os.flush();//ˢ���������ʹServer�����յ����ַ�����Ϣ
			
        	//��Server�����ַ���������ӡ����Ļ��
			System.out.println("Msg from server is:"+is.readLine());
			
			System.out.print("Client input:");
			line=stdin.readLine(); //���ִӼ��̶�����Ϣ
        }//����ѭ��
        os.close(); //�ر������
        is.close(); //�ر�������
        cs.close(); //�ر� client socket
        System.out.println("client is closed...");
      }catch(IOException e){
    	  e.printStackTrace();
      }
}

    public static void main(String[] args) throws Exception {
        new TCPClient();
    }
}
