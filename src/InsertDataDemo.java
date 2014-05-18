//package com.howtodoinjava.jdbc.demo;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
public class InsertDataDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LINGUAL", "root", "mysql");
             
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO CUSTOMER(CID,CNAME) "
                                + "VALUES (100,'Gupta')");
            System.out.println("\n row inserted");
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}