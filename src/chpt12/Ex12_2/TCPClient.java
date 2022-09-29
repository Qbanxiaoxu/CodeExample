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
        	 cs = new Socket("127.0.0.1",6666);//创建一个Client socket并绑定端口号9999  
        	 os = new PrintWriter(cs.getOutputStream(),true);//打开输出流
        }catch (UnknownHostException e) {
                System.err.println("Failed to get Server hostname");
                System.exit(1);
        } catch (IOException e) {
        	System.err.println("Failed to create socket");
            System.exit(1);
		}

      //由Socket对象获得输出流，并创建PrintWriter对象
		PrintWriter os=new PrintWriter(cs.getOutputStream());
		
		//由Socket对象获得输入流，并创建BufferedReader对象
		BufferedReader is=new BufferedReader(new InputStreamReader(cs.getInputStream()));
		
		//创建标准输入BufferedReader对象
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Client input:");
        String line=stdin.readLine(); //从键盘读入字符串
		
        while(!line.equals("bye")) {//从键盘读入的字符串若为 "bye"则停止循环     
        	os.println(line);//将从键盘读入的字符串输出到Server 
        	os.flush();//刷新输出流，使Server立刻收到该字符串信息
			
        	//从Server读入字符串，并打印到屏幕上
			System.out.println("Msg from server is:"+is.readLine());
			
			System.out.print("Client input:");
			line=stdin.readLine(); //保持从键盘读入信息
        }//继续循环
        os.close(); //关闭输出流
        is.close(); //关闭输入流
        cs.close(); //关闭 client socket
        System.out.println("client is closed...");
      }catch(IOException e){
    	  e.printStackTrace();
      }
}

    public static void main(String[] args) throws Exception {
        new TCPClient();
    }
}
