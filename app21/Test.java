package com.marina.app21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
//executeUpdate() method with Select sql query Type 1 Driver
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			con = DriverManager.getConnection("jdbc:odbc:mar", "system", "marina");
			st = con.createStatement();
			int rowCount = st.executeUpdate("select * from emp1"); //No row count was produced
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				ResultSet rs = st.getResultSet();
				System.out.println("ENO\tENAME\tESAL\tEADDR");
				System.out.println("-------------------------------------");
				while (rs.next()) {
					System.out.print(rs.getInt("ENO") + "\t");
					System.out.print(rs.getString("ENAME") + "\t");
					System.out.print(rs.getFloat("ESAL") + "\t");
					System.out.print(rs.getString("EADDR") + "\n");
				}
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
