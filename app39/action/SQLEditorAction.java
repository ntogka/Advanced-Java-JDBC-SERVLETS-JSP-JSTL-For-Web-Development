package com.marina.app39.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLEditorAction {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	public SQLEditorAction() {
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			st = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean executeQuery(String query) {
		boolean b = false;
		try {
			b = st.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	public ResultSet getResultSet() {
		try {
			rs = st.getResultSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = st.getUpdateCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}