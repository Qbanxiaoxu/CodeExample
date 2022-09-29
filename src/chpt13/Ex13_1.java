package chpt13;

//Ex13_1.java
import java.nio.*;
import java.nio.channels.FileChannel;
import java.io.*;

public class Ex13_1 {
	public static void main(String[] args) throws IOException{
		
	RandomAccessFile aFile = new RandomAccessFile("niodata.txt", "rw");
	FileChannel inChannel = aFile.getChannel();//打开一个通道inChannel
	ByteBuffer buf = ByteBuffer.allocate(48);//创建一个指定大小的Buffer

	int bytesRead = inChannel.read(buf);//通过通道,读取文件中的数据放到Buffer中
	while (bytesRead != -1) {
		System.out.println("Read " + bytesRead);
		buf.flip();  //转换Buffer模式，准备从Buffer中读出数据
		while(buf.hasRemaining()){
			System.out.print((char) buf.get());
		}
		buf.clear();
		bytesRead = inChannel.read(buf);
	}
	aFile.close();
	}
}
