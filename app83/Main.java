package com.marina.app83;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Main {
//Connection Pooling: Connection pooling With JNDI Example
/*
JNDI: Java Naming and Directory Interface, it is a middleware service declared by JEE and implemented by all the application servers.

The main intention of JNDI is to provide Global scope to the resources inorder to share throughout the server that
is to all the applications which are deployed in the application servers.

Steps to Implement Connection Pooling Mechanism through JNDI:
---------------------------------------------------------------
1. Download and Install Weblogic Server.
2. Configure JNDI and DataSource in Weblogic Server.
3. Prepare Jdbc Application to get DataSource from Server.
4. Execute Jdbc Application
 */
    public static void main(String[] args) {

        DataSource ds = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Hashtable<String, String> ht = new Hashtable<>();
            ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            ht.put(Context.PROVIDER_URL,"t3://localhost:7001");
            InitialContext context = new InitialContext(ht);

            ds = (DataSource) context.lookup("marinajndi");
            con = ds.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from emp1");
            System.out.println("ENO\tENAME\tESAL\tEADDR");
            System.out.println("------------------------------");
            while(rs.next()){
                System.out.print(rs.getInt("ENO")+"\t");
                System.out.print(rs.getString("ENAME")+"\t\t");
                System.out.print(rs.getFloat("ESAL")+"\t");
                System.out.print(rs.getString("EADDR")+"\n");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                rs.close();
                st.close();
                con.close();

            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}