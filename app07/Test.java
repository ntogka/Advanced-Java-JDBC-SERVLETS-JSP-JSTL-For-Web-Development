package com.marina.app07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	//type-1 driver
	//droping table from Database.
    //drop table emp1;
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection con = null;
		Statement st = null;
		
		try {
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:mar", "system", "marina");
			st = con.createStatement();
			st.executeUpdate("drop table emp3");
			System.out.println("Table emp3 dropped Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		

	}

}
