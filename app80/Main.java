package com.marina.app80;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
//Connection Pooling: C3P0 Mech
/*
C3P0:
---------
JARS: c3p0-version.jar
      mchange-commons-java-version.jar
      ojdbc8.jar
 */
    public static void main(String[] args) {

        ComboPooledDataSource ds = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            ds = new ComboPooledDataSource();
            ds.setDriverClass("oracle.jdbc.OracleDriver");
            ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
            ds.setUser("system");
            ds.setPassword("marina");
            ds.setMinPoolSize(5);
            ds.setMaxPoolSize(10);

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
            try {
                rs.close();
                st.close();
                con.close();
                //ds.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}