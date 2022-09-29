package chpt6;

public class Ex6_9 {
	 public Paper pp(String s) {
		//内部类定义开始
	    return new Paper() {
	       private String line;    
	       public String mark(){ 
	    	   line=s;
	    	   return line; 
	       }
	    }; //分号在这里是必须的，标记表达式的结束
	 }
     public static void main(String[] args) {
	    Ex6_9 p = new Ex6_9();
	    Paper c = p.pp("Happ lamp and grey wolf");
	    System.out.println(c.mark());
	 }
}
