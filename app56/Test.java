package com.marina.app56;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Test {
//PreparedStatement: Dates Insertion
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
            
            pst = con.prepareStatement("insert into emp2 values(?,?,?,?)");
            
            pst.setInt(1, 222);
            pst.setString(2, "BBB");
            
            java.util.Date dt = new java.util.Date();
            long time = dt.getTime();
            java.sql.Date doj = new java.sql.Date(time);
            pst.setDate(3, doj);
            
            java.sql.Date dob = java.sql.Date.valueOf("1996-12-28");
            pst.setDate(4, dob);
            
            int rowCount = pst.executeUpdate();
            if(rowCount == 1) {
                System.out.println("Employee Inserted Successfully");
            }else {
                System.out.println("Employee Insertion Failure");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                pst.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
