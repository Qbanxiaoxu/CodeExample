package chpt8;

//Ex8_6.java
import java.io.*;
class Ex8_6{
  public static void main ( String[] args )throws IOException {
    String fileName = "c:\\myjava\\code\\data.dat" ;
    //写各种基本类型数据到文件
//将DataOutputStream与FileOutputStream连接可输出不同类型的数据
     FileOutputStream fos = new FileOutputStream(fileName);
     DataOutputStream dos = new DataOutputStream (fos);

     dos.writeBoolean(true);
     dos.writeByte((byte)123);
     dos.writeChar('K');
     dos.writeDouble(3.141592654);
     dos.writeFloat(2.2345f);
     dos.writeInt(1234567890);
     dos.writeLong(1234567890123456789L);
     dos.writeShort((short)1234);
     dos.writeUTF("string string string");
     dos.close();
      }
 }
