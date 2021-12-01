package com.marina.app30;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Test {
//Different approaches to establish Connection between Java application and Database
//By Using DriverManager.getConnection() with Properties File
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:/Users/mnto/eclipse-workspace/app30/src/com/marina/app30/resources/db.properties");
			Properties p = new Properties();
			p.load(fis);
			String driverClass = p.getProperty("driverClass");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			/* p.load(fis);			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",p);
			gia db.properties user = system password = marina
			*/

			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.print(rs.getString("EADDR")+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}