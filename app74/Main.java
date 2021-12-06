package com.marina.app74;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
//Transaction Management: Atomicity Example-3
/*
Transferring some amount from one account to another account ,
where both the accounts are existed in two different banks that is in two different databases.

We must connect with two databases from single jdbc application.

    1. We must add both the databases provided driver jars.
    2. We must load both drivers.
    3. We must create two Connection objects, we must remove
       auto-commit nature from both the connections.
    4. We must create two Statements
    5. We must perform operations on both the databases.
    6. We must perform commit / rollback on both the
       connections.
 */
    public static void main(String[] args) {

        Connection oracleCon = null;
        Connection mysqlCon = null;

        Statement oracleSt = null;
        Statement mysqlSt = null;

        try {

            Class.forName("oracle.jdbc.OracleDriver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            oracleCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","marina");
            mysqlCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb","root","marina");

            oracleCon.setAutoCommit(false);
            mysqlCon.setAutoCommit(false);

            oracleSt = oracleCon.createStatement();
            mysqlSt = mysqlCon.createStatement();

            int rowCount1 = oracleSt.executeUpdate("update account set BALANCE = BALANCE - 5000 where ACCNO = " +
                    "'abc123'");
            int rowCount2 = mysqlSt.executeUpdate("update account set BALANCE = BALANCE + 5000 where ACCNO = 'xyz123'");

            if(rowCount1 == 1 && rowCount2 == 1){
                oracleCon.commit();
                mysqlCon.commit();
                System.out.println("Transaction Success");
            }else{
                oracleCon.rollback();
                mysqlCon.rollback();
                System.out.println("Transaction Failure");
            }

        }
        catch (Exception e) {
            //e.printStackTrace();
            try {
                oracleCon.rollback();
                mysqlCon.rollback();
                System.out.println("Transaction Failure");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        finally {

            try {
                oracleCon.close();
                mysqlCon.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}