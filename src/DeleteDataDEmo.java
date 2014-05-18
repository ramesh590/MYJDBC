import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class DeleteDataDEmo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lingual", "root", "mysql");
             
            stmt = connection.createStatement();
            stmt.execute("DELETE FROM CUSTOMER WHERE CID = 101");
            ResultSet rs=stmt.executeQuery("select * from customer");
            System.out.println("CID"+"\t"+"CNAME");
            while(rs.next())            {
            	System.out.println(rs.getInt("cid")+"\t"+rs.getString("cname"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {  if(connection!=null){
                stmt.close();
                connection.close();}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }  
}