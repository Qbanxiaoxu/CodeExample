package chpt8;

import java.io.*;
class Ex8_2
{
  public static void main ( String[] args ) throws IOException
    //main�����������׳�IO�쳣
  {
    String fileName = "C:\\myjava\\code\\Hello.txt" ;//ע�⡯\����ת�������Ҫʹ�á�/����\\��"E:\\myjava\\code\\Hello.txt"
    FileWriter writer = new FileWriter( fileName );//����һ�������ļ��������������
    writer.write( "I'm here \n");   //���ļ���д�ַ���
    writer.write( "This is my first text file\n"  );
    writer.write(200);  //д������
    writer.write( "You can see how this is done.\n" );
    writer.write("������������\n");
    writer.close();   //�ر���
  }
}
