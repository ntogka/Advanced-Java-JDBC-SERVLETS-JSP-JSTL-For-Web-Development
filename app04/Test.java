package com.marina.app04.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	//type-1 driver
	//Inserting records in database table by taking records 
    //data as Dynamic Input.
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection con = null;
		Statement st = null;
		try {
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:mar", "system", "marina");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.print("Employee Number    : ");
				int eno = Integer.parseInt(br.readLine());
				System.out.print("Employee Name      : ");
				String ename = br.readLine();
				System.out.print("Employee Salary    : ");
				float esal = Float.parseFloat(br.readLine());
				System.out.print("Employee Address   : ");
				String eaddr = br.readLine();
				
				int rowCount = st.executeUpdate("insert into emp1 values(" + eno + ", '" + ename + "', " + esal + ",'" + eaddr + "')" );
				if (rowCount == 1) {
					System.out.println("Employee " + eno + " Inserted Successfully");
				} else {
					System.out.println("Employee " + eno + " Insertion Failure");
				}
				
				System.out.print("One more Employee[yes/no] ?   : ");
				String option = br.readLine();
				if (option.equalsIgnoreCase("yes")) {
					continue;
				} else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
