package com.marina.app92;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.io.FileOutputStream;

public class Main {
//RowSets: WebRowSet Read Operation Example
    /*
    Steps to read data from Database to an XMl file by using WebRowSet:
---------------------------------------------------------------------
1. Create WebRowSet object:

WebRowSet rowSet = RowSetProvider.newFactory().createWebRowSet();

2. Set Jdbc parameters to WebRowSet:

rowSet.setUrl("jdbc:mysql://localhost:3306/marinadb");
rowSet.setUsername("root");
rowSet.setPassword("marina");

3. Set select sql query to WebRowSet:

rowSet.setCommand("select * from emp1");

4. Execute select sql query:

rowSet.execute();

5. Prepare Target XML File either by using FileOutputSTream or by
   using FileWriter:

FileOutputStream fos = new FileOutputStream("D:/documents/emp.xml");

6. Write RowSet data to the target XML file:

rowSet.writeXml(fos);
     */
    public static void main(String[] args) {
        WebRowSet rowSet = null;
        FileOutputStream fos = null;

        try {

            rowSet = RowSetProvider.newFactory().createWebRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/marinadb");
            rowSet.setUsername("root");
            rowSet.setPassword("marina");

            rowSet.setCommand("select * from emp1");
            rowSet.execute();

            fos = new FileOutputStream("C:/Users/mnto/Desktop/IntelliJ/emp.xml");
            rowSet.writeXml(fos);
            System.out.println("Employee Data Send to C:/Users/mnto/Desktop/IntelliJ/emp.xml");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                fos.close();
                rowSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
/*
If we execute the above program then we will get emp.xml file which includes the following three types of tags mainly.

1.<properties> tag
2.<metadata> tag
3.<data> tag

Where <properties> tag is able to manage all the properties of the RowSet object like command, url, username, password, table name,....

Where <metadata> tag is able to manage metadata of the RowSet which includes no of columns, column names, database name, column data types,....


Where <data> tag contains the actual records data in the form of <currentRow> tags.
*/
