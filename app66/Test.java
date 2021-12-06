package com.marina.app66;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
//CLOB : Read Example
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Reader reader = null;
        FileWriter fileWriter = null;       
        
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
            pst = con.prepareStatement("select * from webapps where APPNAME = ?");
            pst.setString(1, "app01");
            rs = pst.executeQuery();
            rs.next();
            fileWriter = new FileWriter("C:/Users/mnto/Desktop/java/depldesc.xml");
            reader = rs.getCharacterStream("DEPLDESC");
            
            int val = reader.read();
            while(val != -1) {
                fileWriter.write(val);
                val = reader.read();
            }
            
            System.out.println("Web Application Details");
            System.out.println("-----------------------------");
            System.out.println("Application Name      : "+rs.getString("APPNAME"));
            System.out.println("Deployment Descriptor : C:/Users/mnto/Desktop/java/depldesc.xml");
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                fileWriter.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}