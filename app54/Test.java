package com.marina.app54;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test {
//PreparedStatement: Delete Example
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        Scanner scanner = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
            pst = con.prepareStatement("delete from emp1 where ESAL < ?");
            
            scanner = new Scanner(System.in);
            System.out.print("Salary Range    : ");
            float salRange = scanner.nextFloat();
            
            pst.setFloat(1, salRange);
            int rowCount = pst.executeUpdate();
            System.out.println("Employees Deleted   : "+rowCount);
            
            
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