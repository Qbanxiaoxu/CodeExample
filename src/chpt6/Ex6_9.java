package chpt6;

public class Ex6_9 {
	 public Paper pp(String s) {
		//�ڲ��ඨ�忪ʼ
	    return new Paper() {
	       private String line;    
	       public String mark(){ 
	    	   line=s;
	    	   return line; 
	       }
	    }; //�ֺ��������Ǳ���ģ���Ǳ��ʽ�Ľ���
	 }
     public static void main(String[] args) {
	    Ex6_9 p = new Ex6_9();
	    Paper c = p.pp("Happ lamp and grey wolf");
	    System.out.println(c.mark());
	 }
}
