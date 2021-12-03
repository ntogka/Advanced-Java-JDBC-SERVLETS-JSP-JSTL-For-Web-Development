package com.marina.app63;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {
//BLOB : Insert Example
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        FileInputStream fis = null;
        
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
            
            pst = con.prepareStatement("insert into emp20 values(?,?,?)");
            pst.setInt(1, 111);
            pst.setString(2, "m");

            File file = new File("C:/Users/mnto/Desktop/image/m.jpg");
            fis = new FileInputStream(file);
            pst.setBinaryStream(3, fis, file.length());
            
            int rowCount = pst.executeUpdate();
            if(rowCount == 1) {
                System.out.println("Employee Inserted Successfully");
            }else {
                System.out.println("Employee Insertion Failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}