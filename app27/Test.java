package com.marina.app27;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
//Displaying Data through CSV file
	//exw idio apotelesma kai an valw .txt, mou ftiaxnei txt file
	public static void main(String[] args) {
		try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from emp1");
				FileOutputStream fos = new FileOutputStream("C:/Users/mnto/Desktop/abc/emp.csv");
		) {
			String data = "ENO,ENAME,ESAL,EADDR\n";
			while (rs.next()) {
				data = data + rs.getInt("ENO") + ",";
				data = data + rs.getString("ENAME") + ",";
				data = data + rs.getFloat("ESAL") + ",";
				data = data + rs.getString("EADDR") + "\n";
			}
			byte[] b = data.getBytes();
			fos.write(b);
			System.out.println("Employee Data Send to C:/Users/mnto/Desktop/abc/emp.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
