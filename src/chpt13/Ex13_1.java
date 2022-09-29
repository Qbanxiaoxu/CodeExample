package chpt13;

//Ex13_1.java
import java.nio.*;
import java.nio.channels.FileChannel;
import java.io.*;

public class Ex13_1 {
	public static void main(String[] args) throws IOException{
		
	RandomAccessFile aFile = new RandomAccessFile("niodata.txt", "rw");
	FileChannel inChannel = aFile.getChannel();//��һ��ͨ��inChannel
	ByteBuffer buf = ByteBuffer.allocate(48);//����һ��ָ����С��Buffer

	int bytesRead = inChannel.read(buf);//ͨ��ͨ��,��ȡ�ļ��е����ݷŵ�Buffer��
	while (bytesRead != -1) {
		System.out.println("Read " + bytesRead);
		buf.flip();  //ת��Bufferģʽ��׼����Buffer�ж�������
		while(buf.hasRemaining()){
			System.out.print((char) buf.get());
		}
		buf.clear();
		bytesRead = inChannel.read(buf);
	}
	aFile.close();
	}
}
