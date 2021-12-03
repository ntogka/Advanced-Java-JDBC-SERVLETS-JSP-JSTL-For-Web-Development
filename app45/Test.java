package com.marina.app45;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
//Scroll Insensitive ResultSet
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			/*
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
			*/
			/*
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			*/
			/*
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:mar", "system", "marina");
			*/
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:mysqldsn", "root", "marina");
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from emp1");
			System.out.println("Employee Details Before Updations");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("--------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.print(rs.getString("EADDR")+"\n");
			}
			System.out.println("Application is in Pausing State, please");
			System.out.println("Perform Updations in Database table and perform Commit operation");
			System.in.read();// It will pause the program untill we click on Enter button
			
			rs.beforeFirst();
			System.out.println("Employee Details After Updations");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("--------------------------------");
			while(rs.next()) {
				rs.refreshRow();
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
/*
It is a ResultSet object, it should not allow later database updations after creating ResultSet object.

Type-4 Driver provided by MySQL is supporting only Scroll Sensntive ResultSet object, it is not supporting Scroll Insensitive ResultSet object.

Type-4 Driver provided by Oracle is not supporting both Scroll Sensitive ResultSet object and Scroll Insensitive ResultSets.

Type-1 Driver with Oracle Database is supporting Scrollable ResultSet objects upto Scroll Sensntive ResultSet, it is not supporting Scroll insensitive ResultSet object.
  
Type-1 Driver with MySQL Database is not supporting Scroll Sensitive ResultSet object and it is supporting Scroll insensntive ResultSet Object.
 */
	}

}