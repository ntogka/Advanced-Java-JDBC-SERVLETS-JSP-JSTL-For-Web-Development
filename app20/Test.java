package com.marina.app20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	// executeUpdate() method with DDL Sql Queries with Type 4 Driver
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
		Statement st = con.createStatement();
		int rowCount1 = st.executeUpdate("create table emp2(ENO number(3) primary Key, ENAME varchar2(10))");
		System.out.println(rowCount1);
		int rowCount2 = st.executeUpdate("drop table emp2");
		System.out.println(rowCount2);
		con.close();

	}

}
