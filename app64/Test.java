package com.marina.app64;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
//BLOB : Read Example
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        FileOutputStream fos = null;
        InputStream is = null;
        
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
            pst = con.prepareStatement("select * from emp20 where ENO = ?");
            pst.setInt(1, 111);
            rs = pst.executeQuery();
            rs.next();
            
            fos = new FileOutputStream("C:/Users/mnto/Desktop/image/m.jpg");
            is = rs.getBinaryStream("IMAGE");
            int val = is.read();
            while(val != -1) {
                fos.write(val);
                val = is.read();
            }
            
            
            System.out.println("Employee Details");
            System.out.println("---------------------------");
            System.out.println("Employee Number  : "+rs.getInt("ENO"));
            System.out.println("Employee Name    : "+rs.getString("ENAME"));
            System.out.println("Employee Image   : C:/Users/mnto/Desktop/image/m.jpg");
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                fos.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}