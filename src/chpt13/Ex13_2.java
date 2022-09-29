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
		//打开一个Channel
		ServerSocketChannel channel = ServerSocketChannel.open();
		Selector selector = Selector.open();//打开一个Selector	
		channel.configureBlocking(false);//设置Channel为非阻塞模式
		//注册Channel到Selector
		SelectionKey key = channel.register(selector,SelectionKey.OP_READ);
		while(true) {//// 轮询访问selector
		  int readyChannels = selector.select();//选择Channel
		  if(readyChannels == 0) continue;
		  Set selectedKeys = selector.selectedKeys();//访问就绪Channel
		  Iterator keyIterator = selectedKeys.iterator();
		  while(keyIterator.hasNext()) { //遍历所有就绪Channel
			  key =(SelectionKey) keyIterator.next();
		    if(key.isAcceptable()) {
		        //ServerSocketChannel接收到一个连接
		    } else if (key.isConnectable()) {
		        //和远程的服务器建立连接
		    } else if (key.isReadable()) {
		        //Channel进入读模式
		    } else if (key.isWritable()) {
		        //Channel进入写模式
		    }
		  }
		}
	}
}
