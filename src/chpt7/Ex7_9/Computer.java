package chpt7.Ex7_9;
//Computer.java
public class Computer extends Product
{
	protected int memory;
	protected String ProcessorName;
	
	  public Computer(){ 
	      //此处隐含调用构造方法 Product()  
	   }
	   
	  	Computer(int aID, String aname, String acategories, double aPrice,int amemory,String aProcessorName)
	  	{ 
	      super(aID, aname, acategories,aPrice);
	      memory=amemory; 
	      ProcessorName = aProcessorName;
	   }

	  public String toString(){
		  return (super.toString()+"memory:"+memory+"\n"+"ProcesssorName:"+ProcessorName+"\n");
	  }
	

	int memory()
    {
       return memory;
    }

    String getProcessorName()
    {
       return ProcessorName;
    }
}


