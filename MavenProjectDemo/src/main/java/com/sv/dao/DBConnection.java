package com.sv.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;
public class DBConnection {


    public static Connection getConnection(){
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUser("root");
        ds.setPassword("pqr123");
        ds.setUrl("jdbc:mysql://localhost:3306/company_db");

        Connection c = null;

        try {
            c = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void main(String[] args) throws SQLException {

        Connection con = getConnection();

        if (con != null) {
            System.out.println("Database Connected Successfully!");
        } else {
            System.out.println("Connection Failed!");
        }
    }
}