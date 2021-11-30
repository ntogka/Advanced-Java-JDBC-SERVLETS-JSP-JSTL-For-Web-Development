package com.marina.app02.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	//type-1 driver 
	//creating table in Database by taking table name as Dynamic input.
	public static void main(String[] args) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:mar", "system", "marina");
		Statement st = con.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Table Name [Employee Related] : ");
		String tname = br.readLine();
		st.executeUpdate("create table " + tname + "(ENO number(3) primary key, ENAME varchar(10), ESAL float(5), EADDR varchar2(10))");
		System.out.println("Table " + tname + " Created Successfully");
		br.close();
		st.close();
		con.close();

	}

}
