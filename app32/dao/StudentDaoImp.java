package com.marina.app32.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.marina.app32.dto.Student;
import com.marina.app32.factory.ConnectionFactory;

public class StudentDaoImp implements StudentDao {

	@Override
	public String add(Student student) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			Student std = search(student.getSid());
			if (std == null) {
				int rowCount = st.executeUpdate("insert into student values'(" + student.getSid() + "','" + student.getSname() + "','" + student.getSaddr() + "')");
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			} else {
				status = "existed";
			}
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student student = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student where SID = '" + sid + "'" );
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

	@Override
	public String update(Student newStudent) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			int rowCount = st.executeUpdate("update student set SNAME = '" + newStudent.getSname() + "', SADDR = '" + newStudent.getSaddr() + "' where SID = '" + newStudent.getSid() + "'");
			if (rowCount == 1) {
				status = "success";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(Student sid) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			Student student = search(sid);
			if (student == null) {
				status = "notexisted";
			} else {
				int rowCount = st.executeUpdate("delete from student where SID = '" + sid + "'");
				if (rowCount == 1) {
					status = "success";
				}else {
					status = "failure";
				}
			}
		} catch (Exception e) {
			status "failure";
			e.printStackTrace();
		}
		return status;
	}

}
