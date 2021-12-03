package com.marina.app61;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
//SQLInjection Attack Problem With Statement In MySQL
	/*
	 provlima otan vazw to swsto username me '#, vgazei swsto pasword kai as vazw lathos
	 */
    public static void main(String[] args) {
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        BufferedReader br = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
            st = con.createStatement();
            
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("User Name    : ");
            String uname = br.readLine();
            System.out.print("Password     : ");
            String upwd = br.readLine();
            
            String query = "select * from reg_Users where UNAME = '"+uname+"' and UPWD = '"+upwd+"'";
            System.out.println();
            System.out.println(query);
            System.out.println();
            rs = st.executeQuery(query);
            boolean b = rs.next();
            if(b == true) {
                System.out.println("Valid User, Credentials are Valid");
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