package assign3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 
 * Usage:
 * Connection con = MyDB.getConnection();
 * 
 * Optional, but recommended: Call the close function when you no longer need to work with the database
 * MyDB.close()
 */
public class MyDB {
	
	private static final String MYSQL_USERNAME = "yourStudentID";
	private static final String MYSQL_PASSWORD = "123456";
	private static final String MYSQL_DATABASE_SERVER = "mysql-user.muc";
	private static final String MYSQL_DATABASE_NAME = "myUniversity";
	
	private static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/" + MYSQL_DATABASE_NAME;
			con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("student: Update the MySQL constants to correct values!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("student: Add the MySQL jar file to your build path!");
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
