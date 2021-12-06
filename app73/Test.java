package com.marina.app73;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
//Transaction Management: Atomicity Example-2
    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","marina");
            con.setAutoCommit(false);
            st = con.createStatement();
            int rowCount1 = st.executeUpdate("update account set BALANCE = BALANCE - 5000 where ACCNO = 'abc123'");
            int rowCount2 = st.executeUpdate("update account set BALANCE = BALANCE + 5000 where ACCNO = 'xyz123'");
            if(rowCount1 == 1 && rowCount2 == 1){
                con.commit();
                System.out.println("Transaction Success");
            }else{
                con.rollback();
                System.out.println("Transaction Failure");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        finally {
            try {
                con.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}