package com.marina.app86;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Main {
//RowSets: JdbcRowSet Update operation
    /*
    Steps to update database table through JdbcRowSet:
----------------------------------------------------
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

5. Move to the Cursor to the record which we want to update:
    rowSet.absolute(3);

6. Perform Updations in RowSet:
    float sal = rowSet.getFloat(3);
    rowSet.updateFloat(3, sal+500);

7. Update database table:
    rowSet.updateRow();
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
                    float newSal = sal + 500;
                    rowSet.updateFloat(3,newSal);
                    rowSet.updateRow();
                    System.out.println("Employee "+rowSet.getInt("ENO")+" Updated Successfully");
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