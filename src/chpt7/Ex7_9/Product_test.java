package chpt7.Ex7_9;
import java.util.*;
import chpt7.Ex7_9.Computer;
import chpt7.Ex7_9.Laptop;
import chpt7.Ex7_9.Product;

public class Product_test {

	public static void main(String[] args){
		Product tt = new Product(11,"lenovo","desktop",5000);
		Computer ter = new Computer(123,"dell","desktop",3000,516,"hp");
		Laptop mac = new Laptop(456,"apple","laptop",3456,516,"hp",1.3,26);
		
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(tt.getID(),tt.getName());
		map.put(ter.getID(),ter.getName());
		map.put(mac.getID(),mac.getName());
		
		Set<Integer> set=map.keySet();
		System.out.println("Map集合中所有元素是：");
		Iterator<Integer> it=set.iterator();
		while (it.hasNext()){
			Integer key=(Integer)it.next();
			String name=(String) map.get(key);
			System.out.println(key+" "+name);
		}
		map.remove(123); //将id为“123”的对象从集合中删除。
		System.out.println("Map集合中执行删除操作后所有元素是：");
		Iterator<Integer> it2=set.iterator();
		while (it2.hasNext()){
			Integer key=(Integer)it2.next();
			String name=(String) map.get(key);
			System.out.println(key+" "+name);
		}
	}
}
