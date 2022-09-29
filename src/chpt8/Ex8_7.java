package chpt8;

//Ex8_7.java
import java.io.*; 
class Ex8_7{
  public static void main ( String[] args ) throws IOException {
    	String fileName = "c:\\myjava\\code\\binary.dat" ;
    	DataOutputStream dataOut = new DataOutputStream(
                             new BufferedOutputStream(
                               new FileOutputStream( fileName  ) ) );
    	dataOut.writeInt( 0 );
    	System.out.println( dataOut.size()  + " bytes have been written.");
    	dataOut.writeDouble( 31.2 );
    	System.out.println( dataOut.size()  + " bytes have been written.");
    	dataOut.writeBytes("this is string");
    	System.out.println( dataOut.size()  + " bytes have been written.");
    	dataOut.close();
  }
}
