/*
create or replace function getAVGSal(no1 IN number, no2 IN number) return FLOAT
AS
   sal1 float;
   sal2 float;
BEGIN
   select ESAL into sal1 from emp1 where ENO = no1;
   select ESAL into sal2 from emp1 where ENO = no2;
   return (sal1+sal2)/2;
END getAVGSal;
/ 
 * 
//to trexis sto cmd sto sqlplus
*/
package com.marina.app68;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Test {
//CallableStatement: Example with Function
   public static void main(String[] args) {
       
       Connection con = null;
       CallableStatement cst = null;
       
       try {
           Class.forName("oracle.jdbc.OracleDriver");
           con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
           cst = con.prepareCall("{? = call getAVGSal(?,?)}");
           cst.setInt(2, 111);
           cst.setInt(3, 222);
           cst.registerOutParameter(1, Types.FLOAT);
           cst.execute();
           System.out.println("111 and 222 Employees AVG Salary : "+cst.getFloat(1));
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
