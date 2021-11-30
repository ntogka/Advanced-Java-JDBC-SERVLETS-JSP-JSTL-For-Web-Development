package com.marina.app03.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	//type-1 driver
	//creating table in Database by taking table name, Column
    //Names, Column Sizes, Column Data Types and Primary Keys as Dynamic input.
	public static void main(String[] args) throws Exception {
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:mar", "system", "marina");
		Statement st = con.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Table name  : ");
		String tname = br.readLine();
		String primaryKeyColumns = "";
		int primaryColCount = 0;
		String query = "create table " + tname + "(";
		while(true) {
			System.out.println();
			System.out.print("Column Name         : ");
			String colName = br.readLine();
			System.out.print("Column Data Type    : ");
			String colDataType = br.readLine();
			System.out.print("Column Size         : ");
			int colSize = Integer.parseInt(br.readLine()); //gia na to diavasoume os int
			query = query + colName + " " + colDataType + "(" + colSize + ")";
			System.out.print("Is Primary Key[yes/no]? : ");
			String primaryKeyOption = br.readLine();
			if(primaryKeyOption.equalsIgnoreCase("yes")) {
				primaryColCount = primaryColCount + 1;
				if (primaryColCount == 1) {
					primaryKeyColumns = primaryKeyColumns + colName;
				} else {
					primaryKeyColumns = primaryKeyColumns + "," + colName;
				}
				
			}
			
			System.out.print("One more Column[Yes/No] :");
			String nextColumnOption = br.readLine();
			if (nextColumnOption.equalsIgnoreCase("yes")) {
				query = query + ",";
				continue;
			} else {
				query = query + ", primary key(" + primaryKeyColumns + "))";
				break;
			}
			
		
		}
		//System.out.println(query);
		st.executeUpdate(query);
		System.out.println("Table " + tname + " Created Successfully");
		br.close();
		st.close();
		con.close();
		
	}

}
