package com.marina.app75;

import java.sql.*;

public class Main {
//Transaction Management: Savepoint Example
/*
Savepoint feature is supported by Type-4 Driver provided by Oracle Database up to setSavepoint() and rollback() method,
 it is not supporting releaseSavepoint() method.
 In case of Type-4 Driver provided by Oracle if we use releaseSavepoint() method then JVM will raise an exception like
 "java.sql.SQLFeatureNotSupportedException: Unsupported feature: releaseSavepoint".

Savepoint feature is supported by Type-4 Driver provided by MySQL database up to all setSavepoint(), rollback(), releaseSavepoint() methods.
 */
    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

        try {
            /*
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","marina");
            */
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb","root","marina");
            con.setAutoCommit(false);

            st = con.createStatement();
            st.executeUpdate("insert into emp1 values(111, 'AAA', 5000, 'Hyd')");
            Savepoint sp = con.setSavepoint();
            st.executeUpdate("insert into emp1 values(222, 'BBB', 6000, 'Hyd')");
            //con.rollback(sp);
            con.releaseSavepoint(sp);
            st.executeUpdate("insert into emp1 values(333, 'CCC', 7000, 'Hyd')");
            con.commit();
            System.out.println("Transaction Success");
        }
        catch (Exception e) {
            e.printStackTrace();

            try {
                con.rollback();
                System.out.println("Transaction Failure");
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        finally {

        }

    }
}