package chpt10.Ex10_9.ProductPackage;
import java.sql.SQLException;

public abstract class Product
{
	protected int number_ID;
	public String name;		//��Ʒ������
	String category;	//��Ʒ������
	double price;		//��Ʒ�ļ۸�
	String description;	//��Ʒ������
	
	//���������Ĺ��캯��
	public Product()
	{
		this("","",0,"");
	}
	//�����������Ĺ��캯��
	public Product(String initName,String initCate,double initPrice)
	{
		this(initName,initCate,initPrice,"");
	}
	//���ĸ������Ĺ��캯��
	public Product(String initName, String initCate, double initPrice, String initDes)
	{
		number_ID=0;
		name=initName;
		category=initCate;
		price=initPrice;
		description=initDes;
	}
	
	public void setProductID(int countID)
	{
		number_ID=countID;
	}
	public String getNumber_ID()		//return the ID of product
	{
		return new java.text.DecimalFormat("000000").format(number_ID);
	}
	public String getPrice()			//return the Price of product
	{
		return new java.text.DecimalFormat("$0.00").format(price);
	}
	public abstract void storeToDB() throws SQLException, ClassNotFoundException;	//������Ϣ�����ݿ�
	public abstract void addition(String[] value) throws Exception;//����µĲ�Ʒ��Ϣ
}