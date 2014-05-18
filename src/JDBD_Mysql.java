
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBD_Mysql {
	/* static block is executed when a class is loaded into memory 
	   * this block loads MySQL's JDBC driver
	   */
	  static
	  {
	    try
	    {
	      // loads com.mysql.jdbc.Driver into memory
	      Class.forName("com.mysql.jdbc.Driver");
	    } 
	    catch (ClassNotFoundException cnf) 
	    {
	      System.out.println("Driver could not be loaded: " + cnf);
	    }
	  }
	 
	  public static void main(String[] args)
	  {
	    String connectionUrl = "jdbc:mysql://localhost:3306/lingual";
	    String dbUser = "root";
	    String dbPwd = "mysql";
	    Connection conn;
	    ResultSet rs;
	    String queryString = "SELECT cid, cname FROM customer";
	 
	    try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	 
	      // INSERT A RECORD
	      stmt.executeUpdate("INSERT INTO customer (cid,cname) VALUES (200,\"TINU K\")");
	 
	      // SELECT ALL RECORDS FROM EXPTABLE
	      rs = stmt.executeQuery(queryString);
	 
	      System.out.println("ID \tNAME");
	      System.out.println("============");
	      while(rs.next())
	      {
	        System.out.print(rs.getInt("cid") + "\t" + rs.getString("cname"));
	        System.out.println();
	      }
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }
	  }

}
