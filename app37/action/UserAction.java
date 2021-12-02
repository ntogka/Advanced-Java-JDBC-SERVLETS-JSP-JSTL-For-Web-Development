package com.marina.app37.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserAction {
	Connection con;
	Statement st;
	ResultSet rs;
	
	public UserAction() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String checkLogin(String uname, String upwd) {
		String status = "";
		try {
			rs = st.executeQuery("select * from reg_Users where UNAME = '"+uname+"' and UPWD = '"+upwd+"'");
			boolean b = rs.next();
			if(b == true) {
				status = "SUCCESS";
			}else {
				status = "FAILURE";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}