package com.marina.app13;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class Test {
	//MetaData in Jdbc
	//Note: When we want to work with an unknown database , there, 
	//to get some details about the database there we will use "DatabaseMetaData".
	public static void main(String[] args) {
		Connection con = null;
		DatabaseMetaData md = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			md = con.getMetaData();
			System.out.println(md.getDatabaseProductName());
			System.out.println(md.getDatabaseProductVersion());
			System.out.println(md.getDriverMinorVersion());
			System.out.println(md.getDriverMajorVersion());
			System.out.println(md.getSQLKeywords());
			System.out.println(md.getNumericFunctions());
			System.out.println(md.getStringFunctions());
			System.out.println(md.supportsStoredProcedures());
			System.out.println(md.supportsBatchUpdates());
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
