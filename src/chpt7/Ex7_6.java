package chpt7;

//Ex7_6.java
import java.util.*;
public class Ex7_6 {
	    public static void main(String[] args) {
		{
			ArrayList<String> cartoons = new ArrayList<String>();
			cartoons.add("grey wolf");
			cartoons.add("little red riding hood");

		//创建一个cartoons集合对应的迭代器
		Iterator<String> it = cartoons.iterator();
		while (it.hasNext())
		{	
			String mm =(String)it.next();
			System.out.println("remove: "+mm);
		    if(mm.equals("grey wolf"))
				it.remove();
		    System.out.println("cartoons is: "+it.next());		
		}
	}
 }
}
