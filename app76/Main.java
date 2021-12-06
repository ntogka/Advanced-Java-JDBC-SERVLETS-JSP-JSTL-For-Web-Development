package com.marina.app76;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

class MyConnectionPooling{
    private static List<Connection> pool = new ArrayList<>(5);

    static {

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
            Connection con2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
            Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
            Connection con4 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
            Connection con5 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "marina");
            pool.add(con1);
            pool.add(con2);
            pool.add(con3);
            pool.add(con4);
            pool.add(con5);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        if (pool.size() != 0) {
            con = pool.get(0);
            pool.remove(0);
        }
        return con;
    }

    public static void close(Connection con) {
        pool.add(con);
    }
    public static int getPoolSize(){
        return pool.size();
    }
}

public class Main {


    public static void main(String[] args) {
        System.out.println(MyConnectionPooling.getPoolSize());
        Connection con1 = MyConnectionPooling.getConnection();
        System.out.println(MyConnectionPooling.getPoolSize());
        Connection con2 = MyConnectionPooling.getConnection();
        Connection con3 = MyConnectionPooling.getConnection();
        System.out.println(MyConnectionPooling.getPoolSize());
        MyConnectionPooling.close(con1);
        System.out.println(MyConnectionPooling.getPoolSize());
        MyConnectionPooling.close(con2);
        MyConnectionPooling.close(con3);
        System.out.println(MyConnectionPooling.getPoolSize());
    }
}