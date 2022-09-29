package chpt6;

//Ex6_7.java
abstract class Pencil{
     abstract public int value();
}
interface Paper{
     String mark();
}
class WriteStory {
    private class MyPencil extends Pencil { //定义一个private类继承自抽象类
         private int i = 5;
         public int value() { return i; }
    }
    protected class MyPaper implements Paper{//实现了接口Paper
         private String line;
         private MyPaper(String str) { line= str;}
         public String mark() { 
        	 return line; 
        }
     }
    public Paper writeDown(String s) { 
    		return new MyPaper(s); 
    	}
    public Pencil pen() { return new MyPencil(); }
}
public class Ex6_7{
   public static void main(String[] args) {
       WriteStory w = new WriteStory ();
       Paper c = w.writeDown("Happy lamb and grey wolf");
       System.out.println(c.mark());
       Pencil d = w.pen();
       System.out.println(d.value());
  }
} 
