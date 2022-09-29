package chpt10.Ex10_9.ProductPackage;
import java.sql.*;

import chpt10.Ex10_9.MainPackage.Management;

public class Software extends Product
{
	int reqSpace;		//required space
	String os;			//required operating system
	String softType;	//software type(e.g. program, utilities)
	//不带参数的构造函数
	public Software()
	{
		this("",0,"",0,"","");
	}
	//带参数的构造函数
	public Software(String initName, double initPrice, String initDes,int initSpace,String initOS,String initType)
	{
		super(initName,"Software",initPrice,initDes);
		reqSpace=initSpace;
		os=initOS;
		softType=initType;
	}
	public String getreqSpace()		//return the requaired space
	{
		return new java.text.DecimalFormat("0.0MB").format(reqSpace);
	}
	//添加新的产品信息
	public void addition(String[] value) throws Exception
	{
		int i=0;
		this.name=value[i++];
		this.price=Double.valueOf(value[i++]);
		this.description=value[i++];
		this.reqSpace=Integer.valueOf(value[i++]);
		this.os=value[i++];
		this.softType=value[i++];
	}
	//将产品信息添加到数据库中
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into "+
					"Software(ID,Name,Price,Description,RequiredSpace,OperatingSystem,SoftwareType)"+
					"values("+number_ID+",'"+name+"',"+price+",'"+description+"',"+
					reqSpace+",'"+os+"','"+softType+"')";
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
}