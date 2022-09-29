package chpt6;

//Ex6_8.java
public class Ex6_8{
    public Paper pp(String s) {
        class MyPaper implements Paper //方法内部类
        { 
            private String line;            
            MyPaper() {}      
            public String mark(){ 
            	line =s;
            	return line; 
            }
        }//内部类定义结束
        return new MyPaper();
    }
    public static void main(String[] args) {
         Ex6_8 one = new Ex6_8();
         Paper dd = one.pp("Happy lamp and grey wolf");
         System.out.println(dd.mark());
    }
} 

