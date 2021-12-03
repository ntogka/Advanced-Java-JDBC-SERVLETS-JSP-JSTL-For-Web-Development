package com.marina.app59;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
//SQLInjection Attck Problem With Statement In Oracle 
/*
If any SQL query behaviour is changed because of users dynamic input which includes the symbols like ', -,..... then it is called as "SQL Injection Attack".
Dhladi me ta simvola ayta vazontas ta sto username sou vgazei oti einai valid kai as einai invalid, auto einai "SQL Injection Attack"
Vasiko provlima tou Statement sigkekrimena an valis sto username to swsto '--
 */
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        BufferedReader br = null;
        
        try {
        
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
            st = con.createStatement();
            
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("User Name    : ");
            String uname = br.readLine();
            System.out.print("Password     : ");
            String upwd = br.readLine();
            
            rs = st.executeQuery("select * from reg_Users where UNAME = '"+uname+"' and UPWD = '"+upwd+"'");
            boolean b = rs.next();
            if(b == true) {
                System.out.println("Valid User, credentials are valid");
            }else {
                System.out.println("Invalid User, credentials are invalid");
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
