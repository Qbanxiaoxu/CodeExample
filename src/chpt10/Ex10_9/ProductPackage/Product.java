package chpt10.Ex10_9.ProductPackage;
import java.sql.SQLException;

public abstract class Product
{
	protected int number_ID;
	public String name;		//产品的名字
	String category;	//产品的种类
	double price;		//产品的价格
	String description;	//产品的描述
	
	//不带参数的构造函数
	public Product()
	{
		this("","",0,"");
	}
	//带三个参数的构造函数
	public Product(String initName,String initCate,double initPrice)
	{
		this(initName,initCate,initPrice,"");
	}
	//带四个参数的构造函数
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
	public abstract void storeToDB() throws SQLException, ClassNotFoundException;	//保存信息到数据库
	public abstract void addition(String[] value) throws Exception;//添加新的产品信息
}