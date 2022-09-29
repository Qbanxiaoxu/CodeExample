package chpt8;

import java.io.*;
class Ex8_2
{
  public static void main ( String[] args ) throws IOException
    //main方法中声明抛出IO异常
  {
    String fileName = "C:\\myjava\\code\\Hello.txt" ;//注意’\’是转义符，需要使用’/’或’\\’"E:\\myjava\\code\\Hello.txt"
    FileWriter writer = new FileWriter( fileName );//创建一个给定文件名的输出流对象
    writer.write( "I'm here \n");   //往文件里写字符串
    writer.write( "This is my first text file\n"  );
    writer.write(200);  //写入整数
    writer.write( "You can see how this is done.\n" );
    writer.write("接受中文输入\n");
    writer.close();   //关闭流
  }
}
