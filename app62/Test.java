package com.marina.app62;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
//SQLInjection Attack Problem With PreparedStatement In MySQL
	/*
	 * to provlima lithike an xrisimopoihsw PreparedStatement anti Statement
	 */
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        BufferedReader br = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
            pst = con.prepareStatement("select * from reg_Users where UNAME = ? and UPWD = ?");
            
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("User Name   : ");
            String uname = br.readLine();
            System.out.print("Password    : ");
            String upwd = br.readLine();
            
            pst.setString(1, uname);
            pst.setString(2, upwd);
            rs = pst.executeQuery();
            
            boolean b = rs.next();
            if(b == true) {
                System.out.println("Valid User, Credentials are valid");
            }else {
                System.out.println("Invalid User, Credentials are Invalid");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}