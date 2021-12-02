package com.marina.app38.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentAction {
	Connection con;
	Statement st;
	ResultSet rs;
	public StudentAction() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String add(String sid, String sname, String saddr) {
		String status = "";
		try {
			rs = st.executeQuery("select * from student where SID = '"+sid+"'");
			boolean b = rs.next();
			if(b == true) {
				status = "STudent Existed Already";
			}else {
				int rowCount = st.executeUpdate("insert into student values('"+sid+"','"+sname+"','"+saddr+"')");
				if(rowCount == 1) {
					status = "Student Insertion SUCCESS";
				}else {
					status = "Student Insertion Failure";
				}
			}
		} catch (Exception e) {
			status = "Student Insertion Failure";
			e.printStackTrace();
		}
		return status;
	}
}