package com.marina.app51;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
//Batch Updations
    public static void main(String[] args) {
        
        Connection con = null;
        Statement st = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb", "root", "marina");
            st = con.createStatement();
            
            st.addBatch("insert into emp1 values(666,'FFF',5000,'Hyd')");
            st.addBatch("update emp1 set ESAL = ESAL - 500 where ESAL < 10000");
            st.addBatch("delete from emp1 where ENO = 333");
            //st.addBatch("select * from emp1");-->BatchUpdateException
            
            int[] rowCounts = st.executeBatch();
            for(int rowCount: rowCounts) {
                System.out.println("Records Manipulated   : "+rowCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}