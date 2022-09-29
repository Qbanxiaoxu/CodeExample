package chpt6;

//Ex6_6.java
public class  Ex6_6{
    class Pencil { //内部类
        private int i = 10;
        public int value() { return i; }
     }
     class Paper  { //内部类
        private String line;
        Paper(String str)  {   line = str;    }
        String mark() { return line; }
     }
     public void Writing(String story) {
        Pencil pen = new Pencil();
         Paper pa = new Paper(story);
         System.out.println(pa.mark());
      }
public static void main(String[] args)  {
      Ex6_6  p = new Ex6_6();
       p.Writing("Little red riding hood");
    }
} 
