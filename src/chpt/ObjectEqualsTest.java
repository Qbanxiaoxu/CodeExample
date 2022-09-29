
public class ObjectEqualsTest {	
	//1. 基本数据类型，== 是比对值相等
	//2. 对象对比，==与equals默认比对的都是对象地址值
	//3. 对象如果有重写equals的，则按照重写equals功能，比如String, Integer已经重写了equals
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

   //Integer e =200 相当于 Integer e = Integer.valueof(200);
   //如果数值不在（-128~127）范围内，会new一个新的Integer对象，新旧对象值相等，但地址不同。
   
//Integer和String类都重写了equals，实现数值对比，而不是默认的地址对比。
 /* public boolean equals(Object obj) {
		if (obj instanceof Integer){
				return value == (Integer)obj.inValue();
		}
		return false;
	}
	*/
