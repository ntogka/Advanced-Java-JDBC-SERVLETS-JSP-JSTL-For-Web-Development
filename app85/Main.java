package com.marina.app85;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
//RowSets: JdbcRowSet Insert operation Example
    /*
    To insert records into database table throw RowSet we have to use the following steps.

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

5. Move Cursor to after the last record position and take buffer:
    rowSet.afterLast();
         or
    rowSet.moveToInsertRow();

6. Put new Record data in Buffer:
    rowSet.updateInt(1,444);
    rowSet.updateString(2"XXX");
    rowSet.updateFloat(3, 8000);
    rowSet.updateString(4,"Hyd");

7. Insert new Record data into Database:
    rowSet.insertRow();
     */
    public static void main(String[] args) {
        JdbcRowSet rowSet = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/marinadb");
            rowSet.setUsername("root");
            rowSet.setPassword("marina");
            rowSet.setCommand("select * from emp1");
            rowSet.execute();
            rowSet.moveToInsertRow();

            while(true){
                System.out.print("Employee Number    : ");
                int eno = Integer.parseInt(br.readLine());
                System.out.print("Employee Name      : ");
                String ename = br.readLine();
                System.out.print("Employee Salary    : ");
                float esal = Float.parseFloat(br.readLine());
                System.out.print("Employee Address   : ");
                String eaddr = br.readLine();

                rowSet.updateInt(1,eno);
                rowSet.updateString(2,ename);
                rowSet.updateFloat(3,esal);
                rowSet.updateString(4,eaddr);
                rowSet.insertRow();
                System.out.println("Employee "+eno+" Inserted Successfully");
                System.out.print("One more Employee[Yes/No]?   : ");
                String option = br.readLine();
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
                br.close();
                rowSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}