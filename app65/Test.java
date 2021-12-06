package com.marina.app65;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {
//CLOB : Insert Example
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        FileReader fileReader = null;   
        
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
            
            pst = con.prepareStatement("insert into webapps values(?,?)");
            pst.setString(1, "app01");
            
            File file = new File("C:/Users/mnto/Desktop/java/web.xml");
            fileReader = new FileReader(file);
            pst.setCharacterStream(2, fileReader, file.length());
            
            int rowCount = pst.executeUpdate();
            if(rowCount == 1) {
                System.out.println("WebApp Details are stored in Database");
            }else {
                System.out.println("Webapp Details are not stored in Database");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
