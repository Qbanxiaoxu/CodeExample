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
		channel.connect(new InetSocketAddress(ip,port));//�����ӡ���������ʵ�����ǰ�Զ��IP��Port
		//ע��Channel��Selector,��Ϊ��ͨ��ע��CONNECT�¼���
		channel.register(selector, SelectionKey.OP_CONNECT);
	}

	public void listen() throws IOException {
		while (true) {// ��ѯ����selector
			selector.select();
			Iterator ite = this.selector.selectedKeys().iterator();
			while (ite.hasNext()) {//�������о���Channel
				SelectionKey key = (SelectionKey) ite.next();
				ite.remove();// ɾ����ѡ��key,�Է��ظ�����
				if (key.isConnectable()) {//�������¼�����
					SocketChannel channel = (SocketChannel) key.channel();
					if(channel.isConnectionPending()){// �����������
						channel.finishConnect();		
					}
					channel.configureBlocking(false);// ���óɷ�����
					//������˷�����Ϣ
					System.out.println("Client is ready to send msg...");
					channel.write(ByteBuffer.wrap(new String("I am client").getBytes()));
					//��Channel����Ϊ�ɶ��Լ�����ȡ����
					channel.register(this.selector, SelectionKey.OP_READ);
				} else if (key.isReadable()) {	
						//read(key);
				}
			}
		}
	}	
	public void read(SelectionKey key) throws IOException{
		//�ⲿ�ִ�����NIOServer����ͬ
	}		
	public static void main(String[] args) throws IOException {
		NIOClient client = new NIOClient();
		client.initClient("localhost",5555);
		client.listen();
	}
}
