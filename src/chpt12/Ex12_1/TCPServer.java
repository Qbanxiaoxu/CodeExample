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
        	  ss = new ServerSocket(6666); //创建一个ServerSocket监听在端口6666
    		}catch(IOException e){
    			System.err.println("Failed to creat Socket");
    			System.exit(1);
    		}
    		System.out.println("Server is ready...");
    		try{
        	  cs = ss.accept(); //阻塞的accept()方法随时准备接收来自一个Client的请求，返回一个Socket对象    	 
    		}catch (IOException e) {
    			System.err.println("Accept failed.");
    			System.exit(1);
    		}
    		System.out.println("Server is receiving msg from "+ss.getInetAddress()+":"+cs.getPort());
         
    		//由Socket对象获得输入流，并创建BufferedReader对象
            InputStreamReader rs=new InputStreamReader(cs.getInputStream());//打开输入流
            BufferedReader is=new BufferedReader(rs); 
          
            //由Socket对象获得输出流，并创建PrintWriter对象
            PrintWriter os = new PrintWriter(cs.getOutputStream(),true);
            
            //创建键盘输入的BufferedReader对象
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            
          //从Socket中读出来自Client的数据并输出到屏幕
            String line = is.readLine();
            System.out.println("Client msg is:"+line);
            
            //从键盘读入信息   	
        	System.out.print("Server input:");
        	String user = stdIn.readLine();
        	
        	while(!user.equals("bye")){//键盘输入字符串若为 "bye"，则停止循环			
				os.println(user);//向客户端输出字符串			
				os.flush();//刷新输出流，使Client立刻收到该字符串
				
				System.out.println("Msg from client is:"+is.readLine());//保持从Client读入一字符串，并打印到标准输出上
				
				System.out.print("Server input:");
				user=stdIn.readLine();//从键盘读入字符串信息
				
			} //继续循环
            is.close(); //关闭输入流
            os.close(); //关闭输出流
            cs.close(); //与一个客户通信完毕，关闭Client socket
            ss.close();//关闭server socket
    	} catch (IOException ie) {
            ie.printStackTrace();
    	}     
}

    public static void main(String[] args) throws Exception {
        new TCPServer();
    }
}
