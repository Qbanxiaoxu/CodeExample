package chpt2;


public class Ex2_1 {
    public enum week{
    	Sun, Mon, Tue, Wed, Thu, Fri, Sat ;    
    }
    public static void main(String[] args) {
    	week day1 = week.Mon;  //��ֵʱͨ��"ö����.ֵ"��ȡ�����ö���е�ֵ
    	week day2 = week.Thu;
    	
    	int diff = day2.ordinal()-day1.ordinal(); //ordinal�����ó�enumԪ�ص�����
    	
    	System.out.println("day1 order is:"+day1.ordinal());
    	System.out.println("day2 order is:"+day2.ordinal());
    	System.out.println("days diff: "+diff);
    }
}  

  