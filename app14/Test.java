package com.marina.app14;

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
			System.out.println("No Of Columns     : " + columnCount);
			System.out.println();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				System.out.println("Column Name      : " + md.getColumnName(columnIndex));
				System.out.println("Column Data Type : " + md.getColumnTypeName(columnIndex));
				System.out.println("Column Size      : "+ md.getColumnDisplaySize(columnIndex));
				System.out.println("------------------------------");
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
