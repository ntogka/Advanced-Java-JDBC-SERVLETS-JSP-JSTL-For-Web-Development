package com.marina.app49;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
//Updatable ResultSet: Update Operation
/*
2. Updating Records in Database table through Updatable ResultSet:
-------------------------------------------------------------------
1. Create Updatable ResultSet Object.
	Statement st = con.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
	ResultSet rs = st.executeQuery("select * from emp1");
	
2. Perform Updations in ResultSet object.
		float esal = rs.getFloat(3);
		esal = esal + 500;
		rs.updateFloat(3, esal);
		
3. Send these from Updatable ResultSet Object to Database table:
		public void updateRow()throws SQLException
		EX: rs.updateRow();	
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
				float esal = rs.getFloat("ESAL");
				if(esal < 10000) {
					float newSal = esal + 500;
					rs.updateFloat(3, newSal);
					rs.updateRow();
					System.out.println("Employee "+rs.getInt(1)+" Updated Successfully");
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