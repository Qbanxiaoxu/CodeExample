//重写equals()和hashCode()示例
//1.equals()默认比较两个对象地址是否相等，通过重写，可以比较两个对象的内容是否相同
//2.如果两个对象equals()为true，内容相同，但是它们的hashCode()值不同，两个对象仍被认为是不同对象，能够添加到 Set中
//3.必须重写equals()和hashCode(),才能过滤掉Set中重复的对象
import java.util.*;
class Person{
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	/** * 重写toString方法     */        
	public String toString() {      
		return "(" + name + ", " + age + ")";
	}
	/**     * 重写equals方法  ，比较两个对象值的内容*/    
	@Override    
	public boolean equals(Object obj) 
	{  
		if (obj == null) {return false;}
		// 如果是同一个对象返回true，反之返回false 
		if (this == obj) {return true;}
		// 判断是否类型相同  
		if (this.getClass() != obj.getClass()) {
			return false; 
		} 
		Person person = (Person) obj;
		return name.equals(person.name) && age == person.age;
	}
	/**     * 重写hashCode方法     */ 
	public int hashCode() { 
		int nameHash = name.toUpperCase().hashCode(); 
				return nameHash ^ age;    
	}
}


public class HashDemoTest {
	public static void main(String[] args) {
		// 新建Person对象
		Person p1 = new Person("eee",100);
		Person p2 = new Person("eee",100); 
		Person p3 = new Person("aaa",200);
		Person p4 = new Person("EEE",100);
		
		// 新建HashSet对象   
		HashSet<Person> set = new HashSet<>();
		set.add(p1);    
		set.add(p2);    
		set.add(p3);    
		set.add(p4);
		
		// 比较p1 和 p2， 并打印它们的hashCode()    
		System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());    
		// 比较p1 和 p4， 并打印它们的hashCode()    
		System.out.printf("p1.equals(p4) : %s; p1(%d) p4(%d)\n", p1.equals(p4), p1.hashCode(), p4.hashCode());    
		// 打印set    
		System.out.printf("set:%s\n", set);	
	}
}
