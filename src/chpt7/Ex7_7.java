package chpt7;

//ForEachCollection.java

import java.util.*;

public class Ex7_7 
{
	
	public static void main(String[] args) {
		int total=0;
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(new Integer(1));
		c.add(new Integer(2));
		c.add(new Integer(3));
		for (Integer i:c)
			total+=((Integer)i).intValue();

		System.out.println(total);
   }
}
		   
