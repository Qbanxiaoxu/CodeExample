//NIOClient.java
package chpt13.Ex13_3;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOClient {
	private Selector selector;

	public void initClient(String ip,int port) throws IOException {
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		this.selector = Selector.open();	
		channel.connect(new InetSocketAddress(ip,port));//“连接”服务器，实际上是绑定远程IP和Port
		//注册Channel到Selector,并为该通道注册CONNECT事件。
		channel.register(selector, SelectionKey.OP_CONNECT);
	}

	public void listen() throws IOException {
		while (true) {// 轮询访问selector
			selector.select();
			Iterator ite = this.selector.selectedKeys().iterator();
			while (ite.hasNext()) {//遍历所有就绪Channel
				SelectionKey key = (SelectionKey) ite.next();
				ite.remove();// 删除已选的key,以防重复处理
				if (key.isConnectable()) {//有链接事件发生
					SocketChannel channel = (SocketChannel) key.channel();
					if(channel.isConnectionPending()){// 真正完成连接
						channel.finishConnect();		
					}
					channel.configureBlocking(false);// 设置成非阻塞
					//给服务端发送信息
					System.out.println("Client is ready to send msg...");
					channel.write(ByteBuffer.wrap(new String("I am client").getBytes()));
					//给Channel设置为可读以继续读取数据
					channel.register(this.selector, SelectionKey.OP_READ);
				} else if (key.isReadable()) {	
						//read(key);
				}
			}
		}
	}	
	public void read(SelectionKey key) throws IOException{
		//这部分代码与NIOServer的相同
	}		
	public static void main(String[] args) throws IOException {
		NIOClient client = new NIOClient();
		client.initClient("localhost",5555);
		client.listen();
	}
}
