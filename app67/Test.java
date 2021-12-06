/*
create or replace procedure getSal(no IN number, sal OUT float)
AS
BEGIN
   select ESAL into sal from emp1 where ENO = no;
END getSal;
/
   
*/
package com.marina.app67;
//CallableStatement: Example with Procedure
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Test {

   public static void main(String[] args) {
       
       Connection con = null;
       CallableStatement cst = null;
       
       try {
           
           Class.forName("oracle.jdbc.OracleDriver");
           con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
           cst = con.prepareCall("{call getSal(?,?)}");
           cst.setInt(1, 111);
           cst.registerOutParameter(2, Types.FLOAT);
           cst.execute();
           System.out.println("Employee 111 Salary   : "+cst.getFloat(2));
       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           try {
               cst.close();
               con.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }

}