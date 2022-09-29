package chpt10.Ex10_9.ProductPackage;
import java.sql.SQLException;

public class Computer extends Product
{
	String processorName;		//处理器的名字
	double processorSpeed;		//处理器的速度
	int memory;					//内存大小
	//不带参数的构造函数
	public Computer()
	{
		this("",0,"","",0,0);
	}
	//带参数的构造函数
	public Computer(String initName, double initPrice, String initDes,String initPrcName,double initPrcSpd,int initMemory)
	{
		super(initName,"Computer",initPrice,initDes);
		processorName=initPrcName;
		processorSpeed=initPrcSpd;
		memory=initMemory;
	}
	public String getPrcSpd()
	{
		return new java.text.DecimalFormat("0.00GHz").format(processorSpeed);
	}
	public String getMemory()
	{
		return new java.text.DecimalFormat("0.0MB").format(memory);
	}
	public void addition(String[] value) throws Exception{}
	public void storeToDB() throws SQLException,ClassNotFoundException{}
}