//Computer.java
package chpt5.Ex5_6;
public class Computer extends Product
{
	protected int memory;
	protected String ProcessorName;

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


