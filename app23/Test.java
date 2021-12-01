package com.marina.app23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
//executeQuery() method with Non Select sql query type 1 Driver
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			con = DriverManager.getConnection("jdbc:odbc:mar", "system", "marina");
			st = con.createStatement();
			ResultSet rs = st.executeQuery("update emp1 set ESAL = ESAL - 500 where ESAL < 10000");
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				int rowCount = st.getUpdateCount();
				System.out.println("No Of Records Updated  : " + rowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
