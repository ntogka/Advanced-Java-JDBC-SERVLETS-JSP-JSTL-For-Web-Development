package com.marina.app53;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test {
//PreparedStatement: Update Example
    public static void main(String[] args) {
        
        Scanner scanner = null;
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
            pst = con.prepareStatement("update emp1 set ESAL = ESAL + ? where ESAL < ?");
            
            scanner = new Scanner(System.in);
            System.out.print("Bonus Amount   : ");
            int bonusAmount = scanner.nextInt();
            
            System.out.print("Salary Range   : ");
            float salRange = scanner.nextFloat();
            
            pst.setInt(1, bonusAmount);
            pst.setFloat(2, salRange);
            
            int rowCount = pst.executeUpdate();
            System.out.println("Employees Updated   : "+rowCount);
            
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
