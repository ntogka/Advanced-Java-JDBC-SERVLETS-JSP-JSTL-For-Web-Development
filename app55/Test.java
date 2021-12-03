package com.marina.app55;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test {
//PreparedStatement: Select Example
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Scanner scanner = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
            pst = con.prepareStatement("select * from emp1 where ESAL < ?");
            
            scanner = new Scanner(System.in);
            System.out.print("Salary Range    : ");
            float salRange = scanner.nextFloat();
            
            pst.setFloat(1, salRange);
            rs = pst.executeQuery();
            System.out.println("ENO\tENAME\tESAL\tEADDR");
            System.out.println("-----------------------------");
            while(rs.next()) {
                System.out.print(rs.getInt("ENO")+"\t");
                System.out.print(rs.getString("ENAME")+"\t");
                System.out.print(rs.getFloat("ESAL")+"\t");
                System.out.print(rs.getString("EADDR")+"\n");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            
            try {
                scanner.close();
                con.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

    }

}