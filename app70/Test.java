/*
create or replace function getStudents(addr IN varchar2) return SYS_REFCURSOR
AS
   students SYS_REFCURSOR;
BEGIN
   open students for select * from student where SADDR = addr;
   return students;
END getStudents;
/
 * 
 //to trexis sto cmd sto sqlplus
*/

package com.marina.app70;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class Test {
//CallableStatement: CURSOR Types In Function Example
   public static void main(String[] args) {
       
       Connection con = null;
       CallableStatement cst = null;
       ResultSet rs = null;
       
       try {
           Class.forName("oracle.jdbc.OracleDriver");
           con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
           cst = con.prepareCall("{? = call getStudents(?)}");
           cst.setString(2, "Hyd");
           cst.registerOutParameter(1, OracleTypes.CURSOR);
           cst.execute();
           rs = (ResultSet) cst.getObject(1);
           System.out.println("SID\tSNAME\tSADDR");
           System.out.println("----------------------");
           while(rs.next()) {
               System.out.print(rs.getString("SID")+"\t");
               System.out.print(rs.getString("SNAME")+"\t");
               System.out.print(rs.getString("SADDR")+"\n");
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