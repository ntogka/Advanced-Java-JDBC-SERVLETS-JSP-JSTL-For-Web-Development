package com.marina.app17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	//execute() method non select sql query in Jdbc
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			st = con.createStatement();
			boolean b = st.execute("update emp1 set ESAL = ESAL + 500 where ESAL < 10000");
			System.out.println(b); //false because non select
			int rowCount = st.getUpdateCount();
			System.out.println("No of Records Update   : " + rowCount);
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
