package chpt8;

//Ex8_10.java
import java.io.*;
public class Ex8_10
{
	public static void main(String args[]) throws IOException
	{
		//����һ���ļ�
		System.out.println("����һ���ļ�myfile.txt");
		File f = new File("c:\\myjava\\code\\myfile.txt");//�ڴ��д���File�ļ�ӳ�����
		f.createNewFile();//������ʵӲ���ļ�f
		System.out.print(f.getName());
		System.out.println(" Exist?  " + f.exists());
		System.out.println();

		System.out.println("����һ���ļ�myfile1.txt");
		File f1 = new File("c:\\myjava\\code\\myfile1.txt");
		System.out.print(f1.getName());
		System.out.println(" Exist?  " + f1.exists());
		System.out.println();

		System.out.println("myfile.txt������Ϊmyfile1.txt");
		f.renameTo(f1);
		System.out.print(f1.getName());
		System.out.println(" Exist?  " + f1.exists());
		System.out.println();

		System.out.println("ɾ���ļ�myfile1.txt");
		f1.delete();
		System.out.print(f1);
		System.out.println(" Exist?  " + f1.exists());
		
		//�г�Ŀ¼�µ������ļ�
		System.out.println("�г�Ŀ¼�������ļ���");
		String fileName="c:\\myjava\\code"+File.separator;
	       File f2=new File(fileName);
	       String[] str=f2.list();
	       for (int i = 0; i < str.length; i++) {
	           System.out.println(str[i]);
	       }
  }
}
