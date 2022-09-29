package chpt10.Ex10_9.ProductPackage;
import java.sql.SQLException;

import chpt10.Ex10_9.MainPackage.Management;

public class Hometheater extends Stereo
{
	int channel;		//频道
	
	//不带参数的构造函数
	public Hometheater()
	{
		this("",0,"",0,0,0);
	}
	//带参数的构造函数
	public Hometheater(String initName, double initPrice, String initDes,int initSpk,int initWat,int initChannel)
	{
		super(initName,initPrice,initDes,initSpk,initWat);
		category="Hometheater";
		channel=initChannel;
	}
	//添加新的产品信息
	public void addition(String[] value)throws Exception
	{
		int i=0;
		this.name=value[i++];
		this.price=Double.valueOf(value[i++]);
		this.description=value[i++];
		this.speaker=Integer.valueOf(value[i++]);
		this.watts=Integer.valueOf(value[i++]);
		this.channel=Integer.valueOf(value[i++]);
	}
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into "+
					"Hometheater(ID,Name,Price,Description,Speakers,Watts,Channel)"+
					"values("+number_ID+",'"+name+"',"+price+",'"+description+"',"+
					speaker+","+watts+","+channel+")";
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
}