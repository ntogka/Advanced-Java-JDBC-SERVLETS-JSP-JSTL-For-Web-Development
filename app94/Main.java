package com.marina.app94;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
//RowSets: JoinRowSet Example
    /*
    JoinRowSet:
------------
--> The main intention of JoinRowSet is to join two RowSet objects content into single RowSet object:

Steps:
-------
1. Create two tables with a Join Column:

mysql>create table student(SID char(5) primary key, SNAME char(10), SADDR char(10), CID char(5));

mysql>insert into student values('S-111','AAA','Hyd','C-111');
mysql>insert into student values('S-222','BBB','Pune','C-222');
mysql>insert into student values('S-333','CCC','Delhi','C-333');
mysql>insert into student values('S-444','DDD','Chennai','C-444');

2. create table course(CID char(5) primary key, CNAME char(10), CCOST int(5));

mysql>insert into course values('C-111','C',1000);
mysql>insert into course values('C-222','C++',2000);
mysql>insert into course values('C-333','Java',3000);
mysql>insert into course values('C-444','Python',4000);

2. Create CachedRowSet objects w.r.t both the tables:

CachedRowSet rowSet1 = RoeSetProvider.newFactory().createCachedRowSet();
rowSet1.setUrl("---");
rowSet1.setUsername("---");
rowSet1.setPassword("---");
rowSet1.setCommand("select * from student");
rowSet1.execute();

CachedRowSet rowSet2 = RoeSetProvider.newFactory().createCachedRowSet();
rowSet2.setUrl("---");
rowSet2.setUsername("---");
rowSet2.setPassword("---");
rowSet2.setCommand("select * from course");
rowSet2.execute();

3. Create JoinRowSet object:

JoinRowSet rowSet = RowSetProvider.newFactory().createJoinRowSet();

4. Add two RowSet objects to JoinRowSet:

rowSet.addRowSet(rowSet1,4);
rowSet.addRowSet(rowSet2,1);

5. Read data from  JoinRowSet:

while(rowSet.next()){
    -----

}
     */
    public static void main(String[] args) {

        Connection con = null;
        CachedRowSet rowSet1 = null;
        CachedRowSet rowSet2 = null;
        JoinRowSet joinRowSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marinadb","root","marina");

            rowSet1 = RowSetProvider.newFactory().createCachedRowSet();
            rowSet1.setCommand("select * from student");
            rowSet1.execute(con);

            rowSet2 = RowSetProvider.newFactory().createCachedRowSet();
            rowSet2.setCommand("select * from course");
            rowSet2.execute(con);

            joinRowSet = RowSetProvider.newFactory().createJoinRowSet();
            joinRowSet.addRowSet(rowSet1,"CID");
            joinRowSet.addRowSet(rowSet2,"CID");

            System.out.println("SID\t\tSNAME\tSADDR\tCID\t\tCNAME\tCCOST");
            System.out.println("------------------------------------------------");
            while(joinRowSet.next()){
                System.out.print(joinRowSet.getString("SID")+"\t");
                System.out.print(joinRowSet.getString("SNAME")+"\t\t");
                System.out.print(joinRowSet.getString("SADDR")+"\t\t");
                System.out.print(joinRowSet.getString("CID")+"\t");
                System.out.print(joinRowSet.getString("CNAME")+"\t");
                System.out.print(joinRowSet.getInt("CCOST")+"\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                con.close();
                rowSet1.close();
                rowSet2.close();
                joinRowSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}