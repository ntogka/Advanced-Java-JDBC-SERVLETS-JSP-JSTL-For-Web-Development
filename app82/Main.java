package com.marina.app82;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
//Connection Pooling: Hikari Mech
/*
Hikari:
------------
JARS :    HikariCp-version.jar
          slf4j-api-version.jar
          ojdbc8.jar
 */
    public static void main(String[] args) {

        HikariDataSource ds = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            ds = new HikariDataSource();
            ds.setDriverClassName("oracle.jdbc.OracleDriver");
            ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
            ds.setUsername("system");
            ds.setPassword("marina");
            ds.setMinimumIdle(5);
            ds.setMaximumPoolSize(20);
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