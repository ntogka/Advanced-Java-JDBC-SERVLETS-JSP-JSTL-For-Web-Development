package com.marina.app31;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.marina.app31.factory.ConnectionFactory;
////Different approaches to establish Connection between Java application and Database
//By Using Factory Methods and Factory Classes
public class Test {

	public static void main(String[] args) {
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-----------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.print(rs.getString("EADDR")+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(); 
		}

	}

}
