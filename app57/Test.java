package com.marina.app57;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
//PreparedStatement: Dates Read 
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
            pst = con.prepareStatement("select * from emp2");
            rs = pst.executeQuery();
            
            System.out.println("ENO\tENAME\tDOJ\t\tDOB");
            System.out.println("---------------------------------------");
            while(rs.next()) {
                System.out.print(rs.getInt("ENO")+"\t");
                System.out.print(rs.getString("ENAME")+"\t");
                System.out.print(rs.getDate("DOJ")+"\t");
                System.out.print(rs.getDate("DOB")+"\n");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                
                rs.close();
                pst.close();
                con.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}