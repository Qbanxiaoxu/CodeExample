//Star.java
package chpt6.Ex6_2;
public class Star {
	String name;
	int age;
	char sex;	
	public Star(String nm,int ag,char ss)
	{
		name=nm;
		age=ag;
		sex=ss;
	}
	public String toString()
	{
		return ("name: "+name+"\n"+"age: "+age+"\n"+"sex: "+sex+"\n");
	}
	void show(){
		System.out.println("I am famous...");
	}
}
