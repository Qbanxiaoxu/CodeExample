package chpt10.Ex10_9.ProductPackage;
import java.sql.SQLException;

import chpt10.Ex10_9.MainPackage.Management;


public class Laptop extends Computer
{
	double thickness;	//�ʼǱ��ĺ��
	double weight;		//�ʼǱ�������
	
	//���������Ĺ��캯��
	public Laptop()
	{
		this("",0,"","",0,0,0,0);
	}
	//�������Ĺ��캯��
	public Laptop(String initName, double initPrice, String initDes,String initPrcName,double initPrcSpd,int initMemory,double initThick,double initWeight)
	{
		super(initName,initPrice,initDes,initPrcName,initPrcSpd,initMemory);
		category="Laptop";
		thickness=initThick;
		weight=initWeight;
	}
	//����µĲ�Ʒ��Ϣ
	public void addition(String[] value)throws Exception
	{
		int i=0;
		this.name=value[i++];
		this.price=Double.valueOf(value[i++]);
		this.description=value[i++];
		this.processorName=value[i++];
		this.processorSpeed=Double.valueOf(value[i++]);
		this.memory=Integer.valueOf(value[i++]);
		this.thickness=Double.valueOf(value[i++]);
		this.weight=Double.valueOf(value[i++]);
	}
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into "+
					"Laptop(ID,Name,Price,Description,ProcessorName,ProcessorSpeed,Memory,Thickness,Weight)"+
					"values("+number_ID+",'"+name+"',"+price+",'"+description+"','"+
					processorName+"',"+processorSpeed+","+memory+","+thickness+","+weight+")";
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
}