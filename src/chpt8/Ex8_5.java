package chpt8;
//Ex8_5.java
import java.io.*;
class Ex8_5 {
    public static void main(String[] args)throws IOException {
        String fileName = "C:\\myjava\\code\\newHello.txt";
        String line;
        
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            line = in.readLine(); //读取一行内容
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
            in.close();
       }
}
