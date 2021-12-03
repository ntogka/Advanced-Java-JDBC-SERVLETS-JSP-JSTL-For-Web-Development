package com.marina.app52;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test {
//PreparedStatement: Insert Example
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pst = null;
        Scanner scanner = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
            
            pst = con.prepareStatement("insert into emp1 values(?,?,?,?)");
            scanner = new Scanner(System.in);
            
            while(true) {
                
                System.out.print("Employee Number   : ");
                int eno = scanner.nextInt();
                
                System.out.print("Employee Name     : ");
                String ename = scanner.next();
                
                System.out.print("Employee Salary   : ");
                float esal = scanner.nextFloat();
                
                System.out.print("Employee Address  : ");
                String eaddr = scanner.next();
                
                pst.setInt(1, eno);
                pst.setString(2, ename);
                pst.setFloat(3, esal);
                pst.setString(4, eaddr);
                
                int rowCount = pst.executeUpdate();
                if( rowCount == 1 ) {
                    System.out.println("Employee "+eno+" Inserted Successfully");
                    System.out.print("Onemore Employee?[Yes/No]  : ");
                    String option = scanner.next();
                    if(option.equalsIgnoreCase("yes")) {
                        continue;
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Employee "+eno+" Insertion Failure");
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                scanner.close();
                pst.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();                
            }
        }

    }

}