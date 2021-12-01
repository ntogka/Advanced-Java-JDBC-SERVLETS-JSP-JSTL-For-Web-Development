package com.marina.app18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test {
	//execute() with Dynamic SQL Queries

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			st = con.createStatement();
			
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter SQL Query  : ");
			String query = br.readLine();
			boolean b = st.execute(query);
			if(b == true) {
				ResultSet rs = st.getResultSet();
				ResultSetMetaData md = rs.getMetaData();
				int columnCount = md.getColumnCount();
				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
					System.out.print(md.getColumnName(columnIndex) + "\t");
				}
				System.out.println();
				System.out.println("--------------------------------");
				while (rs.next()) {
					for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
						System.out.print(rs.getString(columnIndex) + "\t");
					}
					System.out.println();
				}
			} else {
				int rowCount = st.getUpdateCount();
				System.out.println("RowCount   : " + rowCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
