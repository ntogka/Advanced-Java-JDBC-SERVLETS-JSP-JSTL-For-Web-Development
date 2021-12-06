package com.marina.app72;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
//Transaction Management: Atomicity Example-1
    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","marina");
            con.setAutoCommit(false);
            st = con.createStatement();
            st.executeUpdate("insert into student values('S1','AAA',79)");
            st.executeUpdate("insert into student values('S2','BBB',85)");
            st.executeUpdate("insert into student values('S3','CCC',92)");
            con.commit();
            System.out.println("Transaction Success");
        }
        catch (Exception e) {
            //e.printStackTrace();
            try {
                con.rollback();
                System.out.println("Transaction Failure");
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        finally {

            try {
                con.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}