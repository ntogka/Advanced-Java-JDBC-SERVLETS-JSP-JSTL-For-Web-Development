package com.marina.app90;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
//RowSets: CachedRowSet Update Operation
    /*
Steps to Update the data in Table By Using CachedRowSet:
---------------------------------------------------------
1. Establish Connection between Java application and Database:

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = Drivermanager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");

2. Remove Auto-Commit mode from Connection:

con.setAutoCommit(false);

3. Create CachedRowSet object:

CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();

4. Set Select sql query to RowSet and execute sql query:

rowSet.setCommand("select * from emp1");
rowSet.execute();

5. Move Cursor to the row location to perform updations:

rowSet.absolute(3);

6. Update the data In RowSet:

    float newSal = rowSet.getFloat(3) + 500;
    rowSet.updateFloat(3, newSal);

7. Update Data in Database table:

   rowSet.updateRow();

8. Move cursor to current row and accept changes:

    rowSet.moveToCurrentRow();
    rowSet.acceptChanges();
     */
    public static void main(String[] args) {
        Connection con = null;
        CachedRowSet rowSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb","root","marina");
            con.setAutoCommit(false);

            rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.setCommand("select * from emp1");
            rowSet.execute(con);

            while(rowSet.next()){
                float sal = rowSet.getFloat("ESAL");
                if(sal < 10000){
                    float newSal = sal + 500;
                    rowSet.updateFloat(3, newSal);
                    rowSet.updateRow();
                    rowSet.moveToCurrentRow();
                    rowSet.acceptChanges();
                    System.out.println("Employee "+rowSet.getInt("ENO")+" Updated Successfully");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                con.close();
                rowSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
