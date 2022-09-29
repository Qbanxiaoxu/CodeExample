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
        	  	 ss = new ServerSocket(6666); //创建一个Server Socket监听在端口6666 		
        	  	 System.out.println("Server is ready...");
		}catch(IOException e){
			System.err.println("Failed to creat Socket");
			System.exit(1);
		}
    	while(true){
    		try{
    			 cltsocket = ss.accept(); //阻塞的accept()方法接收Client的请求,返回一个Socket对象
    		}catch (IOException e) {
    	    	System.err.println("Accept failed.");
    	    	System.exit(1);
    	    }
    		clientNum++;
    		//创建b并启动一个线程处理一个Client的请求
    		new MultiServerThread(cltsocket, clientNum).start();  
    	}//end of while
	}

    public static void main(String[] args) throws IOException{
    	new MultiTCPServer();
	}
}	
 //线程           
class MultiServerThread extends Thread
{	
	private Socket cs;
	private int cltNum;
	private ServerSocket ss;
	
	public MultiServerThread(Socket socket, int clientNumber)
    {
		this.cs=socket;
		this.cltNum=clientNumber;		
		System.out.println("Accepted Client：" + cltNum); 
    }
	public void run()
	{		
    	try{	        
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
        	
        	while(!user.equals("bye"))
        	{//键盘输入字符串若为 "bye"，则停止循环			
				os.println(user);//向客户端输出字符串			
				os.flush();//刷新输出流，使Client立刻收到该字符串
				
				//保持从Client读入一字符串，并打印到标准输出上				
				System.out.println("Msg from client is:"+is.readLine());
				System.out.print("Server input:");
				user=stdIn.readLine();//从键盘读入字符串信息
				
			} //继续循环
            is.close(); //关闭输入流
            os.close(); //关闭输出流
            cs.close(); //与一个客户通信完毕，关闭Client socket
    		}catch (IOException ie) {
    			ie.printStackTrace();
    		}
   }//end of run
}

 
