package com.marina.app58;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {
//PreparedStatement: Batch Updations 
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
            pst = con.prepareStatement("insert into emp1 values(?,?,?,?)");
            
            pst.setInt(1, 111);
            pst.setString(2, "AAA");
            pst.setFloat(3, 5000);
            pst.setString(4, "Hyd");
            pst.addBatch();
            
            pst.setInt(1, 222);
            pst.setString(2, "BBB");
            pst.setFloat(3, 6000);
            pst.setString(4, "Pune");
            pst.addBatch();
            
            pst.setInt(1, 333);
            pst.setString(2, "CCC");
            pst.setFloat(3, 7000);
            pst.setString(4, "Chennai");
            pst.addBatch();
            
            pst.setInt(1, 444);
            pst.setString(2, "DDD");
            pst.setFloat(3, 8000);
            pst.setString(4, "Delhi");
            pst.addBatch();
            
            int[] rowCounts = pst.executeBatch();
            
            for(int rowCount: rowCounts) {
                System.out.println("RowCount  : "+rowCount);
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