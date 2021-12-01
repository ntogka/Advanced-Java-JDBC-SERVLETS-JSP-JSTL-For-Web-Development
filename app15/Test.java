package com.marina.app15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test {
	//ResultSetMetaData
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			st = con.createStatement();
			rs = st.executeQuery("select * from emp1");
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				System.out.print(md.getColumnName(columnIndex) + "\t");
			}
			System.out.println();
			System.out.println("------------------------------");
			while (rs.next()) {
				for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
					System.out.print(rs.getString(columnIndex) + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
