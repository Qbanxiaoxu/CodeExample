package chpt9;

import java.sql.*;
public class Ex9_1 {

	public static void main(String args[]) throws ClassNotFoundException
   {
	//连接mysql数据库，连接其他的数据库需要改变格式
	String url = "jdbc:mysql://localhost:3306/exercises?&useSSL=false&serverTimezone=UTC";
    String user ="root";//替换成你自已的数据库用户名
    String password = "xxp666666";//这里替换成你自已的数据库用户密码
    String sqlStr = "select ID,Name,Department from person";
    String sqlInsert = "insert into person " +"VALUES (88, 'May', 'R&D')";
    String sqlUpdate = "update person " +"set Department = 'Marketing' where ID in (1,3)";


    try{   //异常处理语句是必需的.否则不能通过编译!   
        //Class.forName("org.gjt.mm.mysql.Driver");//不可用于8.0版本 driver
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
        System.out.println( "加载驱动成功!" );

        Connection con = DriverManager.getConnection(url, user, password);

        System.out.println( "连接数据库成功!" );

        Statement st = con.createStatement();
        System.out.println( "创建Statement成功!" );
        
        //添加数据
        st.executeUpdate(sqlInsert);
        System.out.println("添加新数据成功");
        
        //更新数据
        st.executeUpdate(sqlUpdate);
        System.out.println("更新数据成功");

        //查询数据
        ResultSet rs = st.executeQuery( sqlStr );
        System.out.println( "查询数据操作成功!" );
        System.out.println( "----------------!" );

        while(rs.next())
        {
          System.out.print(rs.getString("ID") + "   ");
          System.out.print(rs.getString("Name") + "   ");
          System.out.println(rs.getString("Department"));
        }
  
        rs.close();
        st.close();
        con.close();
    }
    catch(SQLException e){
    		System.out.println("ErrorCode:"+e.getErrorCode());
    		System.out.println("SQLState:"+e.getSQLState());
    		System.out.println("reason:"+e.getMessage());    
    }
  }
}
