package com.marina.app87;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Main {
//RowSets: JdbcRowSet Delete operation
    /*
Steps to delete records from Database table through JdbcRowSet:
----------------------------------------------------------------
1. Create JdbcRowSet:
   JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();

2. set jdbcParameters to RowSet:
   rowSet.setUrl(---);
   rowSet.setUsername(--);
   rowSet.setPassword(---);

3. Set select sql query to RowSet object:
   rowSet.setCommand("select * from emp1");

4. Execute Select sql query:
    rowSet.execute();

5. Move to the Cursor to the record which we want to delete:
    rowSet.absolute(3);

6. Delete current Row from Database table:
    rowSet.deleteRow();
     */
    public static void main(String[] args) {
        JdbcRowSet rowSet = null;
        try {
            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/marinadb");
            rowSet.setUsername("root");
            rowSet.setPassword("marina");
            rowSet.setCommand("select * from emp1");
            rowSet.execute();

            while(rowSet.next()){
                float sal = rowSet.getFloat("ESAL");
                if(sal < 10000){
                    int eno = rowSet.getInt("ENO");
                    rowSet.deleteRow();
                    System.out.println("Employee "+eno+" Deleted Successfully");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                rowSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}