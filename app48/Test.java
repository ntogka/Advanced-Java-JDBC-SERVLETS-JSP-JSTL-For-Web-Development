package com.marina.app48;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
//Updatable ResultSet: Insert Operation
/*
	Inserting Records in Database Table:
---------------------------------------
a)Create Updatable ResultSet Object.
	Statement st = con.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
	ResultSet rs = st.executeQuery("select * from emp1");
	
b)Move ResultSet Cursor to after the last record.
	1. public void moveToInsertRow()throws SQLException
	                 or
	2. public void afterLast()throws SQLExcepttion.
	EX: rs.moveToInsertRow();
	           or
		rs.afterLast();
	
	Note: If we use either of the above methods, automatically, ResultSet cursor will come to after the last record in ResultSet object and it will provide a buffer to take new values.
	
c)Provide new values in Buffer inorder to insert.
		public void updateXxx(int colindex, xxx value)
		Where xxx may be byte, short, int, long,......
		EX:
		---
		rs.updateInt(1,111);
		rs.updateStrring(2, "AAA");
		rs.updateFloat(3, 5000);
		rs.updateString(4, "Hyd");
		
d)Insert new record[Current record] from Updatable ResultSet object 
  to Database table permanently. 	
	public void insertRow()throws SQLException
		EX:
		rs.insertRow();
	
Repeate the above steps for each and every records.
*/
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner scanner = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from emp1");
			rs.moveToInsertRow();
			
			scanner = new Scanner(System.in);
			while(true) {
				System.out.print("Employee Number   : ");
				int eno = scanner.nextInt();
				System.out.print("Employee Name     : ");
				String ename = scanner.next();
				System.out.print("Employee Salary   : ");
				float esal = scanner.nextFloat();
				System.out.print("Employee Address  : ");
				String eaddr = scanner.next();
				
				rs.updateInt(1, eno);
				rs.updateString(2, ename);
				rs.updateFloat(3, esal);
				rs.updateString(4, eaddr);
				
				rs.insertRow();
				System.out.println("Employee "+eno+" Inserted Successfully");
				System.out.print("Onemore Employee[yes/No]?   : ");
				String option = scanner.next();
				if(option.equalsIgnoreCase("yes")) {
					continue;
				}else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				scanner.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}