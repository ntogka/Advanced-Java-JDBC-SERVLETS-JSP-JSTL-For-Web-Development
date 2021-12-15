package com.marina.app24.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.marina.app24.beans.Student;

public class StudentAction {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public StudentAction() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Student getStudent(String sid) {
		Student student = null;
		try {
			con.prepareStatement("select * from student where SID = ?");
			pst.setString(1, sid);
			rs = pst.executeQuery();
			boolean b = rs.next();
			if(b == true) {
				student = new Student();
				student.setSid(rs.getString("SID"));
				student.setSname(rs.getString("SNAME"));
				student.setSaddr(rs.getString("SADDR"));
			} else {
				student = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public String update(Student student) {
		String status = "";
		try {
			
			pst = con.prepareStatement("update student set SNAME = ?, SADDR = ? where SID = ?");
			pst.setString(1, student.getSname());
			pst.setString(2, student.getSaddr());
			pst.setString(3, student.getSid());
			int rowCount = pst.executeUpdate();
			
			if (rowCount == 1) {
				status = "success";
			} else {
				status = "failure";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
