package chpt9;

import java.sql.*;
public class Ex9_2 {

	public static void main(String args[]) throws ClassNotFoundException
   {
	//连接mysql数据库，连接其他的数据库需要改变格式
	String url = "jdbc:mysql://localhost:3306/exercises?&useSSL=false&serverTimezone=UTC";
    String user ="root";//替换成你自已的数据库用户名
    String password = "xxp666666";//这里替换成你自已的数据库用户密码
    String sqlStr = "select ID,Name,Department from person";
 
    try{   //异常处理语句是必需的.否则不能通过编译!   
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println( "加载驱动成功!" );

        Connection con = DriverManager.getConnection(url, user, password);

        System.out.println( "连接数据库成功!" );

        //设置ResultSet结果集指针可以来回滚动，并且结果集是可更新的
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        System.out.println( "创建Statement成功!" );
        
        //查询数据
        ResultSet rs = st.executeQuery( sqlStr );
        System.out.println( "查询数据操作成功!" );
        System.out.println( "----------------!" );     

        //光标移动到最后一行
        System.out.println("移动光标到最后一行...");
        rs.last();
         
        //提取最后一行数据
        int id  = rs.getInt("ID");
        String name = rs.getString("Name");
        String dept = rs.getString("Department");
    
        //显示结果
        System.out.print("最后一行记录......");
        System.out.print("ID: " + id);
        System.out.print(", name: " + name);
        System.out.println(", department:" + dept);
       
        System.out.println("显示所有记录......");
        printRs(rs);
         
        //添加新数据
        System.out.println("添加一个新记录......");
        rs.moveToInsertRow();
        rs.updateInt("id",104);
        rs.updateString("Name","Paul");
        rs.updateString("Department","HR"); 
        rs.insertRow();
        System.out.println("添加新记录后，读取出所有记录......");
        printRs(rs);
        
        //删除表中第二个记录
        //首先移动到第二行
        rs.absolute( 2 );
        System.out.println("删除前，列出第二行记录数据...");
        System.out.print(rs.getString("ID") + "   ");
        System.out.print(rs.getString("Name") + "   ");
        System.out.println(rs.getString("Department"));
       //执行删除操作
        rs.deleteRow();
        System.out.println("删除后，列出所有记录...");
        printRs(rs);
        
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
	public static void printRs(ResultSet rs) throws SQLException{
	      //保证每次从头读取
	      rs.beforeFirst();
	      while(rs.next()){
	    	  System.out.print(rs.getString("ID") + "   ");
	          System.out.print(rs.getString("Name") + "   ");
	          System.out.println(rs.getString("Department"));
	     }
	     System.out.println();
	}//end printRs()		
}
