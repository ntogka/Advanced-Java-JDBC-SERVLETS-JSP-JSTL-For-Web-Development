package com.marina.app26;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
//Displaying table Data through Html file
	public static void main(String[] args) {
		try (
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emp1");
			FileOutputStream fos = new FileOutputStream("C:/Users/mnto/Desktop/abc/emp.html");
		){
			String data = "<html><body><table border='1' align='center'>";
			data = data + "<tr><th>ENO</th><th>ENAME</th></th><th>ESAL</th><th>EADDR</th></th>";
			while (rs.next()) {
				data = data + "<tr>";
				data = data + "<td>" + rs.getInt("ENO") + "</td>";
				data = data + "<td>" + rs.getString("ENAME") + "</td>";
				data = data + "<td>" + rs.getFloat("ESAL") + "</td>";
				data = data + "<td>" + rs.getString("EADDR") + "</td>";
				data = data + "</tr>";
			}
			data = data + "</body></html>";
			byte[] b = data.getBytes();
			fos.write(b);
			System.out.println("Employee Data Send to C:/Users/mnto/Desktop/abc/emp.html");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
