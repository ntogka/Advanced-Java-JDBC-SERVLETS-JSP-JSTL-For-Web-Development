/*
create or replace procedure getEmps(salRange IN float, emps OUT SYS_REFCURSOR)
AS
BEGIN
   open emps for select * from emp1 where ESAL < salRange;
END getEmps;
/
 * 
//to trexis sto cmd sto sqlplus
*/

package com.marina.app69;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.internal.OracleTypes;

public class Test {
//CallableStatement: CURSOR Types In Procedure Example
   public static void main(String[] args) {
       
       Connection con = null;
       CallableStatement cst = null;
       ResultSet rs = null;
       
       try {
           Class.forName("oracle.jdbc.OracleDriver");
           con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
           cst = con.prepareCall("{call getEmps(?,?)}");
           cst.setFloat(1, 10000);
           cst.registerOutParameter(2, OracleTypes.CURSOR);
           cst.execute();
           rs = (ResultSet) cst.getObject(2);
           System.out.println("ENO\tENAME\tESAL\tEADDR");
           System.out.println("----------------------------");
           while(rs.next()) {
               System.out.print(rs.getInt("ENO")+"\t");
               System.out.print(rs.getString("ENAME")+"\t");
               System.out.print(rs.getFloat("ESAL")+"\t");
               System.out.print(rs.getString("EADDR")+"\n");
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