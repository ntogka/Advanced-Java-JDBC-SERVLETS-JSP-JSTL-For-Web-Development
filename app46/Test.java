package com.marina.app46;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
/*
Some of the important methods which are supporting Scrollable ResultSets:
-------------------------------------------------------------------
1. public void beforeFirst():
--> It will move ResultSet cursor to before first record position.

2. public void afterLast():
--> It will move ResultSet cursor to After the last record position.

3. public boolean first():
--> It will move ResultSet cursor to first record position.

4. public boolean last():
--> It will move ResultSet cursor to last record position.

5. public boolean relative(int noOfRecords):
--> It can be used to move ResultSet cursor to a record position by jumping the specified no of records. If we provide +ve value as parameter then ResultSet cursor movement will be in forward direction and records count will start from first record. If we provide -ve value as parameter theni ResultSet cursor movement will be in backward direction and records count will start from last record.

6. public boolean absolute(int rowNumber):
--> It can be used to move ResultSet cursor to a particulatr Record position, ifd we provide +ve value as parameter then ResultSet Movement will be in forward direction and records count will start from first record, if we provide -ve value as parameter then ResultSet cursor movement will be in Backward direction and records count will start from last record. 

 */
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb", "root", "root");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from emp1");
			rs.afterLast();
			rs.previous();
			System.out.println(rs.getInt("ENO")+","+rs.getString("ENAME")+","+rs.getFloat("ESAL")+","+rs.getString("EADDR"));
			
			rs.beforeFirst();
			rs.next();
			System.out.println(rs.getInt("ENO")+","+rs.getString("ENAME")+","+rs.getFloat("ESAL")+","+rs.getString("EADDR"));
			
			rs.last();
			System.out.println(rs.getInt("ENO")+","+rs.getString("ENAME")+","+rs.getFloat("ESAL")+","+rs.getString("EADDR"));
			
			rs.first();
			System.out.println(rs.getInt("ENO")+","+rs.getString("ENAME")+","+rs.getFloat("ESAL")+","+rs.getString("EADDR"));
			
			rs.absolute(5);
			System.out.println(rs.getInt("ENO")+","+rs.getString("ENAME")+","+rs.getFloat("ESAL")+","+rs.getString("EADDR"));
			
			rs.absolute(-4);
			System.out.println(rs.getInt("ENO")+","+rs.getString("ENAME")+","+rs.getFloat("ESAL")+","+rs.getString("EADDR"));
		
			rs.first();
			rs.relative(5);
			System.out.println(rs.getInt("ENO")+","+rs.getString("ENAME")+","+rs.getFloat("ESAL")+","+rs.getString("EADDR"));
			
			rs.last();
			rs.relative(-5);
			System.out.println(rs.getInt("ENO")+","+rs.getString("ENAME")+","+rs.getFloat("ESAL")+","+rs.getString("EADDR"));
			
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