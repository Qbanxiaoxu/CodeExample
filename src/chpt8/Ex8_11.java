package chpt8;



//Ex8_11.java
import java.io.*;

public class Ex8_11
{
	public static void main(String args[])
	{
		try
		{
			FileOutputStream fo = new FileOutputStream("c:\\myjava\\code\\newRAFile.ra");
			fo.close();
		}
		catch(Exception e)
		{
			System.out.println(e + "无法创建文件");
		}

		try
		{  //生成随机文件对象
			RandomAccessFile randf = new RandomAccessFile("newRAFile.ra", "rw");

                int data[] = {23,46, 57, 89, 56, 67,34, 6,99, 100};
                System.out.print("写入的数据为：");
                for (int i=0; i<data.length; i++)
                {
                		System.out.print(data[i]+",");
                        randf.writeInt(data[i]);//写入data_arr数据
         
                }
			System.out.println();
			//从文件里读出数据
			System.out.print("读出的数据为：");
            for(int i=data.length-1; i>=0; i--)
            {
            		//将指针指向文件末，反方向逐次读出数据
                  randf.seek(i*4L);  //int数据占4个字节
                  System.out.print(randf.readInt() + ", ");
            }
			System.out.println();

            randf.close();
		}
		catch(Exception e)
		{
			System.out.println(e + "文件读写有误");
		}
	}
}
