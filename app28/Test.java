package com.marina.app28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class Test {
//Approaches to Load Driver class
	
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//OracleDriver driver = new OracleDriver(); //By Creating Driver class Object
			//Class.forName("oracle.jdbc.OracleDriver"); // By Using Class.forName(--) Method
			//DriverManager.registerDriver(new OracleDriver()); //By Using DriverManager.registerDriver(---) Method
			//Optional Case to load Driver it's with none of the line 18,19,20
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			st = con.createStatement();
			rs = st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.print(rs.getString("EADDR")+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}