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
			System.out.println(e + "�޷������ļ�");
		}

		try
		{  //��������ļ�����
			RandomAccessFile randf = new RandomAccessFile("newRAFile.ra", "rw");

                int data[] = {23,46, 57, 89, 56, 67,34, 6,99, 100};
                System.out.print("д�������Ϊ��");
                for (int i=0; i<data.length; i++)
                {
                		System.out.print(data[i]+",");
                        randf.writeInt(data[i]);//д��data_arr����
         
                }
			System.out.println();
			//���ļ����������
			System.out.print("����������Ϊ��");
            for(int i=data.length-1; i>=0; i--)
            {
            		//��ָ��ָ���ļ�ĩ����������ζ�������
                  randf.seek(i*4L);  //int����ռ4���ֽ�
                  System.out.print(randf.readInt() + ", ");
            }
			System.out.println();

            randf.close();
		}
		catch(Exception e)
		{
			System.out.println(e + "�ļ���д����");
		}
	}
}
