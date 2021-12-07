package com.marina.app84;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Main {
//RowSets: JdbcRowSet select operation Example
    /*

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
            System.out.println("Employee Details in Forward Direction");
            System.out.println("ENO\tENAME\tESAL\tEADDR");
            System.out.println("--------------------------------");
            while(rowSet.next()){
                System.out.print(rowSet.getInt("ENO")+"\t");
                System.out.print(rowSet.getString("ENAME")+"\t\t");
                System.out.print(rowSet.getFloat("ESAL")+"\t");
                System.out.print(rowSet.getString("EADDR")+"\n");
            }
            System.out.println();

            System.out.println("Employee Details in Backward Direction");
            System.out.println("ENO\tENAME\tESAL\tEADDR");
            System.out.println("--------------------------------");
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