package chpt8;

//Ex8_3.java
import java.io.*;  
class Ex8_3 {
    public static void main ( String[] args ) throws IOException	
    {
        String fileName = "C:\\myjava\\code\\newHello.txt" ;
        BufferedWriter out = new BufferedWriter(new  FileWriter( fileName ) );
        out.write( "Hello,I'm here" );
        out.newLine() ;
        out.write( "This is another text file"  );
        out.newLine(); 
        out.write( "–¥»Î÷–Œƒ" );
        out.close();
    }
}
