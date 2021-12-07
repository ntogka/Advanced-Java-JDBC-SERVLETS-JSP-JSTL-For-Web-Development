package com.marina.app91;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
//RowSets: CachedRowSet Delete Operation
    /*
 Steps to delete records from database table through CachedRowSet:
------------------------------------------------------------------
1. Establish Connection between Java application and Database:

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = Drivermanager.getConnection("jdbc:mysql://localhost:3306/marinadb","root","marina");

2. Remove Auto-Commit mode from COnnection:

con.setAutoCommit(false);

3. Create CachedRowSet object:

CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();

4. Set Select sql query to RowSet and execute sql query:

rowSet.setCommand("select * from emp1");
rowSet.execute();

5. Move Cursor to the record position to delete:

rowSet.absolute(4);

6. Delete Record:

rowSet.deleteRow();

7. Move Cursor to the current Row and accept the changes:

rowSet.moveToCurrentRow();
rowSet.acceptChanges();
     */
    public static void main(String[] args) {
        CachedRowSet rowSet = null;
        Connection con = null;

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
                    int eno = rowSet.getInt("ENO");
                    rowSet.deleteRow();
                    //rowSet.moveToCurrentRow();
                    rowSet.acceptChanges();
                    System.out.println("Employee "+eno+" Deleted Successfully");
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