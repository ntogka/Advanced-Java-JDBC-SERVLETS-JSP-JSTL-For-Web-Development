package com.marina.app47.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.marina.app47.beans.Employee;

public class PlayerAction {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	boolean flag = true;

	public PlayerAction() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from emp1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Employee getEmployee(String buttonLabel) {
		Employee emp = null;
		try {
			if (buttonLabel.equalsIgnoreCase("First")) {
				flag = rs.first();
			}
			if (buttonLabel.equalsIgnoreCase("Next")) {
				flag = rs.next();
			}
			if (buttonLabel.equalsIgnoreCase("Previous")) {
				flag = rs.previous();
			}
			if (buttonLabel.equalsIgnoreCase("Last")) {
				flag = rs.last();
			}
			if (flag == true) {
				emp = new Employee();
				emp.setEno(rs.getInt("ENO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setEsal(rs.getFloat("ESAL"));
				emp.setEaddr(rs.getString("EADDR"));
			}else {
				emp = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
}