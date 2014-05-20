package com.lingualspeech.myjdbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class MyHindi {
    public static void main(String[] args) {
        Connection connection = null;
       // Statement insertStmt = null;
        Statement selectStmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lingual", "root", "mysql");
             
            /*insertStmt = connection.createStatement();
            insertStmt.execute("INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) VALUES (1,'Lokesh','Gupta',5)");
            insertStmt.execute("INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) VALUES (2,'howtodoinjava','com',5)");*/
             
            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("SELECT * FROM myhindi");
            while(rs.next())
            {
                System.out.print(rs.getInt("hid"));    //First Column
                System.out.print("\t"+rs.getString("hname")+"\n");    //Second Column
                
                
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                selectStmt.close();
               // insertStmt.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
