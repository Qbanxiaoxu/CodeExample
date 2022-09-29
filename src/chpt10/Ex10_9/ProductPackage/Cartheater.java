package chpt10.Ex10_9.ProductPackage;
import java.sql.SQLException;

import chpt10.Ex10_9.MainPackage.Management;

public class Cartheater extends Stereo
{
	Boolean removable;
	
	//���������Ĺ��캯��
	public Cartheater()
	{
		this("",0,"",0,0,false);
	}
	//�������Ĺ��캯��
	public Cartheater(String initName, double initPrice, String initDes,int initSpk,int initWat,boolean initial)
	{
		super(initName,initPrice,initDes,initSpk,initWat);
		category="Cartheater";
		removable=initial;
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
		category="Cartheater";
		if(value[i].length()==0)
			throw new Exception();
		if(value[i].equalsIgnoreCase("true"))
			removable=true;
		else
			removable=false;
	}
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into "+
					"Cartheater(ID,Name,Price,Description,Speakers,Watts,Removable)"+
					"values("+number_ID+",'"+name+"',"+price+",'"+description+"',"+
					speaker+","+watts+",'"+removable+"')";
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
}