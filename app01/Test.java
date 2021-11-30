package com.marina.app001.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
//type-1 driver
	public static void main(String[] args) throws Exception {
		//Load and Register Driver (optional)
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		//Establish Connection between Java application and Database
		Connection con = DriverManager.getConnection("jdbc:odbc:mar", "system", "marina");
		
		//Create Statement
		Statement st = con.createStatement();
		
		//Write and Execute SQL Query
		String query = "create table emp1(ENO number(3) primary key, ENAME varchar(10), ESAL float(5), EADDR varchar2(10))";
		st.executeUpdate(query);
		System.out.println("Table emp1 Created Successfully");
		
		//Close the resources
		st.close();
		con.close();
		

	}

}
