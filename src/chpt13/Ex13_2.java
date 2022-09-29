package chpt13;

//Ex13_2.java
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

public class Ex13_2 {
	public static void main(String[] args) throws IOException {
		//��һ��Channel
		ServerSocketChannel channel = ServerSocketChannel.open();
		Selector selector = Selector.open();//��һ��Selector	
		channel.configureBlocking(false);//����ChannelΪ������ģʽ
		//ע��Channel��Selector
		SelectionKey key = channel.register(selector,SelectionKey.OP_READ);
		while(true) {//// ��ѯ����selector
		  int readyChannels = selector.select();//ѡ��Channel
		  if(readyChannels == 0) continue;
		  Set selectedKeys = selector.selectedKeys();//���ʾ���Channel
		  Iterator keyIterator = selectedKeys.iterator();
		  while(keyIterator.hasNext()) { //�������о���Channel
			  key =(SelectionKey) keyIterator.next();
		    if(key.isAcceptable()) {
		        //ServerSocketChannel���յ�һ������
		    } else if (key.isConnectable()) {
		        //��Զ�̵ķ�������������
		    } else if (key.isReadable()) {
		        //Channel�����ģʽ
		    } else if (key.isWritable()) {
		        //Channel����дģʽ
		    }
		  }
		}
	}
}
