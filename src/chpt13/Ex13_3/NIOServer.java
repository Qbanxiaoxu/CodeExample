//NIOServer.java
package chpt13.Ex13_3;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
	private Selector selector;

	public void initServer(int port) throws IOException {
		ServerSocketChannel serverChannel = ServerSocketChannel.open();//打开一个Channel
		serverChannel.configureBlocking(false);// 设置通道为非阻塞
		// 将该通道对应的ServerSocket绑定到port端口
		serverChannel.socket().bind(new InetSocketAddress(port));
		this.selector = Selector.open();//打开一个Selector
		//注册通道到Selector，并为该通道注册ACCEPT事件
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
	public void listen() throws IOException {
		System.out.println("Server is running...");
		while (true) {// 轮询访问selector
			selector.select(); //选择Channel
			Iterator ite = this.selector.selectedKeys().iterator();
			while (ite.hasNext()) {//遍历所有就绪Channel
				SelectionKey key = (SelectionKey) ite.next();
				ite.remove();// 删除已选的key,以防重复处理
				if (key.isAcceptable()) {//ServerSocketChannel接收到一个连接
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel channel = server.accept();//接受请求
					channel.configureBlocking(false);

					//发送回复给客户
					channel.write(ByteBuffer.wrap(new String("Send Ack back to client...").getBytes()));
				    //给Channel设置可读权限以继续接受请求
					channel.register(this.selector, SelectionKey.OP_READ);
					
				} else if (key.isReadable()) {//Channel进入读模式
						read(key);
				}
			}
		}
	}
	
	public void read(SelectionKey key) throws IOException{
		SocketChannel channel = (SocketChannel) key.channel();//返回一个SocketChannel
		ByteBuffer buffer = ByteBuffer.allocate(50);
		channel.read(buffer);
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println("Server received msg："+msg);
		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
		channel.write(outBuffer);//读取客户传递的数据
	}	
	public static void main(String[] args) throws IOException {
		NIOServer server = new NIOServer();
		server.initServer(5555);
		server.listen();
	}
}
