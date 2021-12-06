package com.marina.app79;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
//Connection Pooling: DBCP Mech Example
/*
DBCP:
---------
JARS: commons-pool-version.jar
      commons-dbcp-version.jar
      commons-logging-version.jar
      ojdbc8.jar / mysql-connector-java-8.2.6.jar
 */
    public static void main(String[] args) {

        BasicDataSource ds = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            ds = new BasicDataSource();
            ds.setDriverClassName("oracle.jdbc.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
            ds.setUsername("system");
            ds.setPassword("marina");
            ds.setInitialSize(5);
            ds.setMaxTotal(10);

            con = ds.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from emp1");
            System.out.println("ENO\tENAME\tESAL\tEADDR");
            System.out.println("-------------------------------");
            while(rs.next()){
                System.out.print(rs.getInt("ENO")+"\t");
                System.out.print(rs.getString("ENAME")+"\t\t");
                System.out.print(rs.getFloat("ESAL")+"\t");
                System.out.print(rs.getString("EADDR")+"\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                rs.close();
                st.close();
                con.close();
                ds.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}