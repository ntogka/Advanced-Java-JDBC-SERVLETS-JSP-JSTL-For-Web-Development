package com.marina.app81;

import org.logicalcobwebs.proxool.ProxoolDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        ProxoolDataSource ds = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            ds = new ProxoolDataSource();
            ds.setDriver("com.mysql.cj.jdbc.Driver");
            ds.setDriverUrl("jdbc:mysql://localhost:3306/marinadb");
            ds.setUser("root");
            ds.setPassword("marina");
            ds.setMinimumConnectionCount(5);
            ds.setMaximumConnectionCount(15);

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

            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}