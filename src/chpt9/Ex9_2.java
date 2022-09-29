package chpt9;

import java.sql.*;
public class Ex9_2 {

	public static void main(String args[]) throws ClassNotFoundException
   {
	//����mysql���ݿ⣬�������������ݿ���Ҫ�ı��ʽ
	String url = "jdbc:mysql://localhost:3306/exercises?&useSSL=false&serverTimezone=UTC";
    String user ="root";//�滻�������ѵ����ݿ��û���
    String password = "xxp666666";//�����滻�������ѵ����ݿ��û�����
    String sqlStr = "select ID,Name,Department from person";
 
    try{   //�쳣��������Ǳ����.������ͨ������!   
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println( "���������ɹ�!" );

        Connection con = DriverManager.getConnection(url, user, password);

        System.out.println( "�������ݿ�ɹ�!" );

        //����ResultSet�����ָ��������ع��������ҽ�����ǿɸ��µ�
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        System.out.println( "����Statement�ɹ�!" );
        
        //��ѯ����
        ResultSet rs = st.executeQuery( sqlStr );
        System.out.println( "��ѯ���ݲ����ɹ�!" );
        System.out.println( "----------------!" );     

        //����ƶ������һ��
        System.out.println("�ƶ���굽���һ��...");
        rs.last();
         
        //��ȡ���һ������
        int id  = rs.getInt("ID");
        String name = rs.getString("Name");
        String dept = rs.getString("Department");
    
        //��ʾ���
        System.out.print("���һ�м�¼......");
        System.out.print("ID: " + id);
        System.out.print(", name: " + name);
        System.out.println(", department:" + dept);
       
        System.out.println("��ʾ���м�¼......");
        printRs(rs);
         
        //���������
        System.out.println("���һ���¼�¼......");
        rs.moveToInsertRow();
        rs.updateInt("id",104);
        rs.updateString("Name","Paul");
        rs.updateString("Department","HR"); 
        rs.insertRow();
        System.out.println("����¼�¼�󣬶�ȡ�����м�¼......");
        printRs(rs);
        
        //ɾ�����еڶ�����¼
        //�����ƶ����ڶ���
        rs.absolute( 2 );
        System.out.println("ɾ��ǰ���г��ڶ��м�¼����...");
        System.out.print(rs.getString("ID") + "   ");
        System.out.print(rs.getString("Name") + "   ");
        System.out.println(rs.getString("Department"));
       //ִ��ɾ������
        rs.deleteRow();
        System.out.println("ɾ�����г����м�¼...");
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
	      //��֤ÿ�δ�ͷ��ȡ
	      rs.beforeFirst();
	      while(rs.next()){
	    	  System.out.print(rs.getString("ID") + "   ");
	          System.out.print(rs.getString("Name") + "   ");
	          System.out.println(rs.getString("Department"));
	     }
	     System.out.println();
	}//end printRs()		
}
