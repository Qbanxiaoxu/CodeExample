package chpt7;

//Ex7_4.java
import java.util.*;
public class Ex7_4<E>
{   //����һ��LinkedList���������Ԫ��������E����
	private LinkedList<E> list=new LinkedList<E>();
	public void push(E o)		//ѹջ
	{
		list.addFirst(o);
	}
	public E top()				//��ѯջ��Ԫ��
	{
		return list.getFirst();
	}		
	public E pop()				//����
	{
		return list.removeFirst();
	}
	public String toString()
	{
		return list.toString();
	}
	public static void main(String[] args)
	{
		//�����������Ԫ������ΪString
		Ex7_4<String> sl=new Ex7_4<String>();
		for(int i=0;i<5;i++)
			sl.push(String.valueOf(i));
		System.out.println("sl="+sl);
	}
}
