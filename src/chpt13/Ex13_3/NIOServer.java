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
		ServerSocketChannel serverChannel = ServerSocketChannel.open();//��һ��Channel
		serverChannel.configureBlocking(false);// ����ͨ��Ϊ������
		// ����ͨ����Ӧ��ServerSocket�󶨵�port�˿�
		serverChannel.socket().bind(new InetSocketAddress(port));
		this.selector = Selector.open();//��һ��Selector
		//ע��ͨ����Selector����Ϊ��ͨ��ע��ACCEPT�¼�
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
	public void listen() throws IOException {
		System.out.println("Server is running...");
		while (true) {// ��ѯ����selector
			selector.select(); //ѡ��Channel
			Iterator ite = this.selector.selectedKeys().iterator();
			while (ite.hasNext()) {//�������о���Channel
				SelectionKey key = (SelectionKey) ite.next();
				ite.remove();// ɾ����ѡ��key,�Է��ظ�����
				if (key.isAcceptable()) {//ServerSocketChannel���յ�һ������
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel channel = server.accept();//��������
					channel.configureBlocking(false);

					//���ͻظ����ͻ�
					channel.write(ByteBuffer.wrap(new String("Send Ack back to client...").getBytes()));
				    //��Channel���ÿɶ�Ȩ���Լ�����������
					channel.register(this.selector, SelectionKey.OP_READ);
					
				} else if (key.isReadable()) {//Channel�����ģʽ
						read(key);
				}
			}
		}
	}
	
	public void read(SelectionKey key) throws IOException{
		SocketChannel channel = (SocketChannel) key.channel();//����һ��SocketChannel
		ByteBuffer buffer = ByteBuffer.allocate(50);
		channel.read(buffer);
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println("Server received msg��"+msg);
		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
		channel.write(outBuffer);//��ȡ�ͻ����ݵ�����
	}	
	public static void main(String[] args) throws IOException {
		NIOServer server = new NIOServer();
		server.initServer(5555);
		server.listen();
	}
}
