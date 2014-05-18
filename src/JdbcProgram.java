import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
/*import java.io.*;
import java.lang.*;
import java.sql.*;
import com.mysql.*;*/


public class JdbcProgram {
/*
	static
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
					}
		catch(ClassNotFoundException cnf)
		{
			System.out.println("Driver could not be found");
		}
	}*/
	public static void main(String args[]) throws Exception
	{
		
		String dbconurl="jdbc:mysql://localhost:3306/lingual";
		String dbna="root";
		String dbpwd="mysql";
		Connection conn=null;
		ResultSet rs;
		String qst="select * from customer";
		
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection(dbconurl,dbna,dbpwd);
		    Statement stmt=conn.createStatement() ;
		   // stmt.executeUpdate("insert into customer values(100,\"ram\")");
		    rs=stmt.executeQuery(qst);
		    System.out.println("ID \t name");
		    System.out.println("==============");
		    while(rs.next())
		    {
		    	System.out.println(rs.getInt("cid")+"\t"+rs.getString("cname"));
		    	System.out.println();
		    }
		    if(conn!=null)
		    {
		    	conn.close();
		    	conn=null;
		    }
		}
		    
		catch(SQLException sqle)
		{
			System.out.println("SQL Exception thrown"+sqle);
		}
				
	}
}
