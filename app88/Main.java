package com.marina.app88;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class Main {
//RowSets: CachedRowSet Read Operation
    /*
    Steps to read data from Database table through CachedRow:
------------------------------------------------------------
1. Create CachedRowSet Object:

CachedRowSewt rowSet = RowSetProvider.newFactory().createCachedRowSet();

2. Set Jdbc Parameters to CachedRowSet:

rowSet.setUrl("---");
rowSet.setUsername("--");
rowSet.setpassword("---");

3. Set select sql query to RowSet:

rowSet.setCommand("select * from emp1");

4. Read data from CachedRow in both Forward direction and Backward direction:

    public boolean next()throws SQLException
    public boolean previous() throws SQLException
    public xxx getXxx(int colIndex/String colName)throws SQLException
     */
    public static void main(String[] args) {
        CachedRowSet rowSet = null;

        try {
            rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/marinadb");
            rowSet.setUsername("root");
            rowSet.setPassword("marina");

            rowSet.setCommand("select * from emp1");
            rowSet.execute();
            System.out.println("Employee Details in Forward Direction");
            System.out.println("ENO\tENAME\tESAL\tEADDR");
            System.out.println("------------------------------");
            while(rowSet.next()){
                System.out.print(rowSet.getInt("ENO")+"\t");
                System.out.print(rowSet.getString("ENAME")+"\t\t");
                System.out.print(rowSet.getFloat("ESAL")+"\t");
                System.out.print(rowSet.getString("EADDR")+"\n");
            }
            System.out.println();

            System.out.println("Employee Details in Backward Direction");
            System.out.println("ENO\tENAME\tESAL\tEADDR");
            System.out.println("------------------------------");
            while(rowSet.previous()){
                System.out.print(rowSet.getInt("ENO")+"\t");
                System.out.print(rowSet.getString("ENAME")+"\t\t");
                System.out.print(rowSet.getFloat("ESAL")+"\t");
                System.out.print(rowSet.getString("EADDR")+"\n");
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