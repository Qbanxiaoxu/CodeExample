//Management.java �����Ը����ֲ�Ʒ�������ݿ�����ķ���
package chpt10.Ex10_9.MainPackage;
import java.sql.*;
import chpt10.Ex10_9.ProductPackage.*;
public class Management
{
	Connection con;			//�����ض����ݿ������ʵ��
	public Statement stmt;			//���������ݿⷢ��SQL����statement����
	public ResultSet rs;			//��������������ܲ�ѯ������صĶ���
	public static int maxId;		//��ŵ�ǰ��Ʒ��ŵ����ֵ
			
	public Management() throws ClassNotFoundException, SQLException	//���������Ĺ��캯��
	{
		con=null;
		stmt=null;
		rs=null;
		maxId=0;
		String url = "jdbc:mysql://localhost:3306/my_product";
	    String user ="root";//�滻�������ѵ����ݿ��û���
	    String password = "654321";//�����滻�������ѵ����ݿ��û�����
		  	     
		  Class.forName("org.gjt.mm.mysql.Driver");
		  System.out.println( "���������ɹ�!" );		  
		  Connection con = DriverManager.getConnection(url, user, password);
		  System.out.println( "�������ݿ�ɹ�!" );
	      stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	      System.out.println( "����Statement�ɹ�!" );
	    
	     rs=stmt.executeQuery("select max(ID) as MaxID from Software");
		  if(rs.next())		//�ж����ݱ��Ƿ��ǿյ�
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
	protected void finalize()throws Throwable		//��������
	{
		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();
		if(con!=null)
			con.close();
	}
	//��ʾ��������Ʒ����Ϣ
	//**********************************************************
	public void display(String name)
	{
		try{	
			rs = stmt.executeQuery("select * from "+name);	//Executes the given SQL statement		
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	//����µĲ�Ʒ��Ϣ
	//**********************************************************
	private void sub_addition(Product item,String[] value) throws SQLException, ClassNotFoundException,Exception
	{
		item.setProductID(++maxId);		//������ƷID
		item.addition(value);
		item.storeToDB();			//�����Ʒ��Ϣ�����ݿ�
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
	//�޸Ĳ�Ʒ����Ϣ
	//**********************************************************
	public void adjustInf(String tabName,String sType,String sValue) throws SQLException
	{
		sValue=sValue.substring(0, sValue.length()-1);
		double value=Double.valueOf(sValue);
		value=value*0.01;
		System.out.println(value);
		if(sType.equalsIgnoreCase("����"))
			stmt.executeUpdate("update "+tabName+" set Price=Price+Price*'"+value+"'");
		else
			stmt.executeUpdate("update "+tabName+" set Price=Price-Price*'"+value+"'");
	}
}