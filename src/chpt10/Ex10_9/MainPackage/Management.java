//Management.java 包含对个各种产品进行数据库操作的方法
package chpt10.Ex10_9.MainPackage;
import java.sql.*;
import chpt10.Ex10_9.ProductPackage.*;
public class Management
{
	Connection con;			//声明特定数据库的连接实例
	public Statement stmt;			//声明向数据库发送SQL语句的statement对象
	public ResultSet rs;			//声明结果集，接受查询结果返回的对象
	public static int maxId;		//存放当前产品编号的最大值
			
	public Management() throws ClassNotFoundException, SQLException	//不带参数的构造函数
	{
		con=null;
		stmt=null;
		rs=null;
		maxId=0;
		String url = "jdbc:mysql://localhost:3306/my_product";
	    String user ="root";//替换成你自已的数据库用户名
	    String password = "654321";//这里替换成你自已的数据库用户密码
		  	     
		  Class.forName("org.gjt.mm.mysql.Driver");
		  System.out.println( "加载驱动成功!" );		  
		  Connection con = DriverManager.getConnection(url, user, password);
		  System.out.println( "连接数据库成功!" );
	      stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	      System.out.println( "创建Statement成功!" );
	    
	     rs=stmt.executeQuery("select max(ID) as MaxID from Software");
		  if(rs.next())		//判断数据表是否是空的
			maxId=(rs.getInt("MaxID")>maxId ? rs.getInt("MaxID") : maxId);
		 rs=stmt.executeQuery("select max(ID) as MaxID from Laptop");
		  if(rs.next())
			maxId=(rs.getInt("MaxID")>maxId ? rs.getInt("MaxID") : maxId);
		  rs=stmt.executeQuery("select max(ID) as MaxID from Desktop");
		  if(rs.next())
			maxId=(rs.getInt("MaxID")>maxId ? rs.getInt("MaxID") : maxId);
		  rs=stmt.executeQuery("select max(ID) as MaxID from Hometheater");
		  if(rs.next())
			maxId=(rs.getInt("MaxID")>maxId ? rs.getInt("MaxID") : maxId);
		  rs=stmt.executeQuery("select max(ID) as MaxID from Cartheater");
		  if(rs.next())
			maxId=(rs.getInt("MaxID")>maxId ? rs.getInt("MaxID") : maxId);
		  if(rs!=null)
			rs.close();	  
   }
	protected void finalize()throws Throwable		//析构函数
	{
		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();
		if(con!=null)
			con.close();
	}
	//显示出所有物品的信息
	//**********************************************************
	public void display(String name)
	{
		try{	
			rs = stmt.executeQuery("select * from "+name);	//Executes the given SQL statement		
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	//添加新的产品信息
	//**********************************************************
	private void sub_addition(Product item,String[] value) throws SQLException, ClassNotFoundException,Exception
	{
		item.setProductID(++maxId);		//产生产品ID
		item.addition(value);
		item.storeToDB();			//保存产品信息到数据库
	}
	public void addition(String tableName,String[] value) throws SQLException, ClassNotFoundException,Exception
	{
		if(tableName.equals("Software"))
		{
			Software item=new Software();
			this.sub_addition(item,value);
		}
		if(tableName.equals("Laptop"))
		{
			Laptop item=new Laptop();
			this.sub_addition(item,value);
		}
		if(tableName.equals("Desktop"))
		{
			Desktop item=new Desktop();
			this.sub_addition(item,value);
		}
		if(tableName.equals("Hometheater"))
		{
			Hometheater item=new Hometheater();
			this.sub_addition(item,value);
		}
		if(tableName.equals("Cartheater"))
		{
			Cartheater item=new Cartheater();
			this.sub_addition(item,value);
		}
	}
	//修改产品的信息
	//**********************************************************
	public void adjustInf(String tabName,String sType,String sValue) throws SQLException
	{
		sValue=sValue.substring(0, sValue.length()-1);
		double value=Double.valueOf(sValue);
		value=value*0.01;
		System.out.println(value);
		if(sType.equalsIgnoreCase("上升"))
			stmt.executeUpdate("update "+tabName+" set Price=Price+Price*'"+value+"'");
		else
			stmt.executeUpdate("update "+tabName+" set Price=Price-Price*'"+value+"'");
	}
}