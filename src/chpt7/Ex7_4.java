package chpt7;

//Ex7_4.java
import java.util.*;
public class Ex7_4<E>
{   //创建一个LinkedList，具体放置元素类型用E代替
	private LinkedList<E> list=new LinkedList<E>();
	public void push(E o)		//压栈
	{
		list.addFirst(o);
	}
	public E top()				//查询栈顶元素
	{
		return list.getFirst();
	}		
	public E pop()				//出堆
	{
		return list.removeFirst();
	}
	public String toString()
	{
		return list.toString();
	}
	public static void main(String[] args)
	{
		//给定具体放置元素类型为String
		Ex7_4<String> sl=new Ex7_4<String>();
		for(int i=0;i<5;i++)
			sl.push(String.valueOf(i));
		System.out.println("sl="+sl);
	}
}
