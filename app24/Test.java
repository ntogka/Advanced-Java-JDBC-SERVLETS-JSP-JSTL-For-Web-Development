package com.marina.app24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	//executeQuery() method with Non Select sql query type 4 Driver
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			st = con.createStatement();
			rs = st.executeQuery("update emp1 set ESAL = ESAL - 500 where ESAL < 10000");
			int rowCount = st.getUpdateCount();
			System.out.println("No Of Records Updated  : " + rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
