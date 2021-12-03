package com.marina.app50;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
//Updatable ResultSet: Delete Operation
/*
3. Deleting Records from Database table through Updatable ResultSet:
--------------------------------------------------------------------
1. Create Updatable ResultSet Object:
	
	Statement st = con.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
	ResultSet rs = st.executeQuery("select * from emp1");

2. Move ResultSet Cursor to the records which we want to delete:
	rs.absolute(3);
	
3. Delete Record from Database table:
	public void deleteRow()throws SQLException
*/
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from emp1");
			while(rs.next()) {
				int eno = rs.getInt("ENO");
				float esal = rs.getFloat("ESAL");
				if(esal < 10000) {
					rs.deleteRow();
					System.out.println("Employee "+eno+" Deleted Successfully");
				}
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