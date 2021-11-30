package com.marina.app05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	//type-1 driver
	//Update records in Database by taking data dynamic input.
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection con = null;
		Statement st = null;
		try {
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:mar", "system", "marina");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Bonus Amount   : ");
			int bonusAmt = Integer.parseInt(br.readLine());
			System.out.print("Salary Range   :");
			float salRange = Float.parseFloat(br.readLine());
			
			int rowCount = st.executeUpdate("update emp1 set ESAL = ESAL + " + bonusAmt + " where ESAL < " + salRange);
			System.out.println("Employee Updated   : " + rowCount);
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
