package chpt8;

//Ex8_10.java
import java.io.*;
public class Ex8_10
{
	public static void main(String args[]) throws IOException
	{
		//创建一个文件
		System.out.println("创建一个文件myfile.txt");
		File f = new File("c:\\myjava\\code\\myfile.txt");//内存中创建File文件映射对象
		f.createNewFile();//创建真实硬盘文件f
		System.out.print(f.getName());
		System.out.println(" Exist?  " + f.exists());
		System.out.println();

		System.out.println("创建一个文件myfile1.txt");
		File f1 = new File("c:\\myjava\\code\\myfile1.txt");
		System.out.print(f1.getName());
		System.out.println(" Exist?  " + f1.exists());
		System.out.println();

		System.out.println("myfile.txt重命名为myfile1.txt");
		f.renameTo(f1);
		System.out.print(f1.getName());
		System.out.println(" Exist?  " + f1.exists());
		System.out.println();

		System.out.println("删除文件myfile1.txt");
		f1.delete();
		System.out.print(f1);
		System.out.println(" Exist?  " + f1.exists());
		
		//列出目录下的所有文件
		System.out.println("列出目录下所有文件：");
		String fileName="c:\\myjava\\code"+File.separator;
	       File f2=new File(fileName);
	       String[] str=f2.list();
	       for (int i = 0; i < str.length; i++) {
	           System.out.println(str[i]);
	       }
  }
}
