package chpt10.Ex10_9.ProductPackage;
import java.sql.SQLException;

public class Stereo extends Product
{
	int speaker;		//number of speakers(e.g. 2)扬声器
	int watts;			//watts (e.g. 1000)功率
	//不带参数的构造函数
	public Stereo()
	{
		this("",0,"",0,0);
	}
	//带参数的构造函数
	public Stereo(String initName, double initPrice, String initDes,int initSpk,int initWat)
	{
		super(initName,"Stereo",initPrice,initDes);
		speaker=initSpk;
		watts=initWat;
	}
	public String getNumSpk()
	{
		return new java.text.DecimalFormat("0个").format(speaker);
	}
	public String getWatts()
	{
		return new java.text.DecimalFormat("0.0W").format(watts);
	}
	public void addition(String[] value) throws Exception{}
	public void storeToDB() throws SQLException, ClassNotFoundException{}
}