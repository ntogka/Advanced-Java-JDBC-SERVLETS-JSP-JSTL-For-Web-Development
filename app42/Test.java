package com.marina.app42;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
//Utilization of Type-5 Driver with mySQL Database
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.ddtek.jdbc.mysql.MySQLDriver");
			con = DriverManager.getConnection("jdbc:datadirect:mysql://localhost:3306;User=root;Password=marina;DatabaseName=marinadb");
			st = con.createStatement();
			rs = st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------------");
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
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
