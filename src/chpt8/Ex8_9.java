package chpt8;

//Ex8_9.java
import java.io.*;
class Ex8_9
{    
public static void main ( String[] args ) 
    {
    	String fileName = "c:\\myjava\\code\\data.dat";
    	int sum = 0;
        try
        {
            DataInputStream ins = new DataInputStream(
            new BufferedInputStream(new FileInputStream( fileName  ) ) );
            System.out.println("\t "+ ins.readBoolean());
            System.out.println("\t "+ ins.readByte());
            System.out.println("\t "+ ins.readChar());
            System.out.println("\t "+ ins.readDouble());
            System.out.println("\t "+ ins.readFloat());
            System.out.println("\t "+ ins.readInt());
            System.out.println("\t "+ ins.readLong());
            System.out.println("\t "+ ins.readShort());
            System.out.println("\t "+ ins.readUTF());
            
            ins.close();
        }
    	catch ( IOException iox )
    	{
            System.out.println("Problem reading " + fileName ); 
        }
    }
}
