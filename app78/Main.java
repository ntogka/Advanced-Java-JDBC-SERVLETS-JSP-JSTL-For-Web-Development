package com.marina.app78;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
//Connection Pooling: Default Connection Pooling Mech With MySQL
    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setURL("jdbc:mysql://localhost:3306/marinadb");
            ds.setUser("root");
            ds.setPassword("marina");

            con = ds.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from emp1");

            System.out.println("ENO\tENAME\tESAL\tEADDR");
            System.out.println("--------------------------------");
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
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}