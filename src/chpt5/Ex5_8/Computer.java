//Computer.java
package chpt5.Ex5_8;
public class Computer extends Product
{
	protected int memory;
	protected String ProcessorName;

	Computer(int a){System.out.println("Computer Constructor...");}
	Computer(){} //默认构造方法，生成new computer()必需
	int memory()
    {
       return memory;
    }

    String getProcessorName()
    {
       return ProcessorName;
    }
    void ads(){
    	System.out.println("This is the best you've ever seen!");
    }
}


