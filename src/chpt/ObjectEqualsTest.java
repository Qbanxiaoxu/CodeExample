
public class ObjectEqualsTest {	
	//1. �����������ͣ�== �Ǳȶ�ֵ���
	//2. ����Աȣ�==��equalsĬ�ϱȶԵĶ��Ƕ����ֵַ
	//3. �����������дequals�ģ�������дequals���ܣ�����String, Integer�Ѿ���д��equals
	public static void main(String[] args) {
		int a=4, b=4;
		Integer c=5, d=5;
		Integer e=200, f=200;
		String str1 = new String("123");
		String str2 = new String("123");
		
		System.out.println(a==b);  //true
		System.out.println(c==d);   //true
		System.out.println(c.equals(d)); //true
		System.out.println(e==f);   //false
		System.out.println(e.equals(f));  //true
		System.out.println(str1==str2);   //false
		System.out.println(str1.equals(str2));  //true	
	
	}
}

   //Integer e =200 �൱�� Integer e = Integer.valueof(200);
   //�����ֵ���ڣ�-128~127����Χ�ڣ���newһ���µ�Integer�����¾ɶ���ֵ��ȣ�����ַ��ͬ��
   
//Integer��String�඼��д��equals��ʵ����ֵ�Աȣ�������Ĭ�ϵĵ�ַ�Աȡ�
 /* public boolean equals(Object obj) {
		if (obj instanceof Integer){
				return value == (Integer)obj.inValue();
		}
		return false;
	}
	*/
