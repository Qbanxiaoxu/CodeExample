package chpt10.Ex10_9.ProductPackage;
import java.sql.SQLException;

import chpt10.Ex10_9.MainPackage.Management;

public class Desktop extends Computer
{
	int monitorSize;	//显示器的大小
	
	//不带参数的构造函数
	public Desktop()
	{
		this("",0,"","",0,0,0);
	}
	//带参数的构造函数
	public Desktop(String initName, double initPrice, String initDes,String initPrcName,double initPrcSpd,int initMemory,int initMsize)
	{
		super(initName,initPrice,initDes,initPrcName,initPrcSpd,initMemory);
		category="Desktop";
		monitorSize=initMsize;
	}
	//添加新的产品信息
	public void addition(String[] value)throws Exception
	{
		int i=0;
		this.name=value[i++];
		this.price=Double.valueOf(value[i++]);
		this.description=value[i++];
		this.processorName=value[i++];
		this.processorSpeed=Double.valueOf(value[i++]);
		this.memory=Integer.valueOf(value[i++]);
		this.monitorSize=Integer.valueOf(value[i++]);
	}
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into "+
					"Desktop(ID,Name,Price,Description,ProcessorName,ProcessorSpeed,Memory,MonitorSize)"+
					"values("+number_ID+",'"+name+"',"+price+",'"+description+"','"+
					processorName+"',"+processorSpeed+","+memory+","+monitorSize+")";
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
}