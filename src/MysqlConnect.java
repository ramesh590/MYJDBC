import java.sql.*;

public class MysqlConnect{
	public static void main(String[] args) {
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/lingual";
		//String dbName = "lingual";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "mysql";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url,userName,password);
			System.out.println("Connected to the database");
			conn.close();
			System.out.println("Disconnected from database");
		 } 
		catch (Exception e) {
		//e.printStackTrace();
			System.out.println("exception raised...");
		}
}
}
