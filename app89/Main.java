package com.marina.app89;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
//RowSets: CachedRowSet Insert Operation
    /*
Steps to insert, update and delete data through CachedRowSet:
--------------------------------------------------------------
1. Establish Connection between Java application and Database:

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = Drivermanager.getConnection("jdbc:mysql://localhost:3306/marinadb","root","marina");

2. Remove Auto-Commit mode from Connection:

con.setAutoCommit(false);

3. Create CachedRowSet object:

CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();

4. Set Select sql query to RowSet and execute sql query:

rowSet.setCommand("select * from emp1");
rowSet.execute();

5. Move Cursor to end of RowSet:

    rowSet.moveToInsertRow();

6. Set Data to new Row:

    rowSet.updateInt(1,111);
    rowSet.updateString(2,"AAA");
    rowSet.updateFloat(3,5000);
    rowSet.updateString(4, "Hyd");

7. Insert record into Database table:

    rowSet.insertRow();

8. Move cursor to the current Row and accept the changes:

    rowSet.moveToCurrentRow();
    rowSet.acceptChanges();
     */
    public static void main(String[] args) {
        Scanner scanner = null;
        CachedRowSet rowSet = null;
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb","root","marina");
            con.setAutoCommit(false);
            scanner = new Scanner(System.in);
            rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.setCommand("select * from emp1");
            rowSet.execute(con);


            while(true){
                System.out.print("Employee Number    : ");
                int eno = scanner.nextInt();
                System.out.print("Employee Name      : ");
                String ename = scanner.next();
                System.out.print("Employee Salary    : ");
                float esal = scanner.nextFloat();
                System.out.print("Employee Address   : ");
                String eaddr = scanner.next();

                rowSet.moveToInsertRow();
                rowSet.updateInt(1,eno);
                rowSet.updateString(2,ename);
                rowSet.updateFloat(3,esal);
                rowSet.updateString(4, eaddr);
                rowSet.insertRow();
                rowSet.moveToCurrentRow();
                rowSet.acceptChanges();


                System.out.println("Employee "+eno+" Inserted Successfully");
                System.out.print("One More Employee[Yes/No]?    : ");
                String option = scanner.next();
                if(option.equalsIgnoreCase("yes")){
                    continue;
                }else{
                    break;
                }

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                rowSet.close();
                scanner.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}