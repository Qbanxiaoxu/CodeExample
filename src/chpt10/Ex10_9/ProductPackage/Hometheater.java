package chpt10.Ex10_9.ProductPackage;
import java.sql.SQLException;

import chpt10.Ex10_9.MainPackage.Management;

public class Hometheater extends Stereo
{
	int channel;		//Ƶ��
	
	//���������Ĺ��캯��
	public Hometheater()
	{
		this("",0,"",0,0,0);
	}
	//�������Ĺ��캯��
	public Hometheater(String initName, double initPrice, String initDes,int initSpk,int initWat,int initChannel)
	{
		super(initName,initPrice,initDes,initSpk,initWat);
		category="Hometheater";
		channel=initChannel;
	}
	//����µĲ�Ʒ��Ϣ
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