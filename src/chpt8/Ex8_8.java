package chpt8;

//Ex8_8.java
import java.io.*;

class Ex8_8
{
    public static void main(String args[]) throws  IOException
    {
	
	//从文件读出存储的数据
        try
        {
             FileInputStream  fis = new FileInputStream("c:\\myjava\\code\\data.dat");
             DataInputStream dis = new DataInputStream(fis);

             System.out.println("Read from file data.dat");
             System.out.println();

             System.out.println("\t "+ dis.readBoolean());
             System.out.println("\t "+ dis.readByte());
             System.out.println("\t "+ dis.readChar());
             System.out.println("\t "+ dis.readDouble());
             System.out.println("\t "+ dis.readFloat());
             System.out.println("\t "+ dis.readInt());
             System.out.println("\t "+ dis.readLong());
             System.out.println("\t "+ dis.readShort());
             System.out.println("\t "+ dis.readUTF());
             
             dis.close();
        }
        catch (IOException ex) {
           System.err.println(ex);
        }
    }
}
