package com.marina.app93;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
//RowSets: WebRowSet Insert,Update,Delete Operations Example
    /*
    Steps to perform insert, update and delete operations by using WebRowSet:
----------------------------------------------------------------------
1. Provide manipulations in the XML file under <data> tag:

    a. Provide new records to insert:

        <insertRow>
            <columnValue>111</columnValue>
            <columnValue>AAA</columnValue>
            <columnValue>5000</columnValue>
            <columnValue>Hyd</columnValue>
        </insertRow>

    b. Provide new Data to Update:

        <currentRow>
            <columnValue>555</columnValue>
            <columnValue>EEE</columnValue>
                <updateRow>XXX</updateRow>
            <columnValue>8000</columnValue>
                <updateRow>9000</updateRow>
            <columnValue>Hyd</columnValue>
                <updateRow>Chennai</updateRow>
        </currentRow>

    c. Specify data to delete:

        <deleteRow>
            <columnValue>111</columnValue>
            <columnValue>AAA</columnValue>
            <columnValue>5000</columnValue>
            <columnValue>Hyd</columnValue>
        </deleteRow>

2. Load and Register Driver:

Class.forName("com.mysql.cj.jdbc.Driver")

3. Establish Connection:

Connection con = DriverManager.getConnection("--","--","---");

4. Recovery Auto-Commit mode from Connection:

con.setAutoCommit(false);

5. Create RowSet Object:

WebRowSet rowSet = RowSetProvider.newFactory().createWebRowSet();


6. Set select sql query to RowSet:

rowSet.setCommand("select * from emp1");

7. Execute select sql query:

rowSet.execute(con);

8. Create FileReader to get data from XML fie:

FileReader fr = new FileReader("C:/Users/mnto/Desktop/IntelliJ/emp.xml");

9. Read data from FileReader and store that data in RowSet object:

rowSet.readXml(fr);

10. Move cursor to the current row and accept the changes:

rowSet.moveToCurrentRow();
rowSet.acceptChanges();
     */
    public static void main(String[] args) {

        FileReader fileReader = null;
        WebRowSet rowSet = null;
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb","root","marina");
            con.setAutoCommit(false);

            rowSet = RowSetProvider.newFactory().createWebRowSet();
            rowSet.setCommand("select * from emp1");
            rowSet.execute(con);

            fileReader = new FileReader("C:/Users/mnto/Desktop/IntelliJ/emp.xml");
            rowSet.readXml(fileReader);

            rowSet.moveToCurrentRow();
            rowSet.acceptChanges();
            System.out.println("insert, update and delete operations are Success");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                fileReader.close();
                con.close();
                rowSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}