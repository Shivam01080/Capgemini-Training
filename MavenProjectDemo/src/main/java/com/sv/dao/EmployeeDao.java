package com.sv.dao;

import java.util.Scanner;

import com.sv.model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {

    public void printAllEmployees() throws SQLException {
        try (Connection con = DBConnection.getConnection();
             Statement s = con.createStatement();
             ResultSet r = s.executeQuery("SELECT * FROM employee")) {
            while (r.next()) {
                int empid = r.getInt("employee_id");
                String firstName = r.getString("first_name");
                String lastName = r.getString("last_name");
                System.out.println(empid + "\t" +
                                   firstName + " " + lastName);
            }
        } finally {
            System.out.println("Done");
        }
    }
    public void getEmployeeById(int id) throws SQLException {

        String query = "SELECT * FROM employee WHERE employee_id = " + id;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            try (ResultSet r = ps.executeQuery()) {

                if (r.next()) {

                    int empid = r.getInt("employee_id");
                    String firstName = r.getString("first_name");
                    String lastName = r.getString("last_name");

                    System.out.println("Employee Found:");
                    System.out.println(empid + "\t" +
                                       firstName + " " + lastName);
                } else {
                    System.out.println("Employee Not Found");
                }
            }
        }
        finally {
        	System.out.println("Finally implemented for getEmployee");
        }
    }
        Employee addEmployee(Employee emp) throws SQLException {
            try (Connection connection = DBConnection.getConnection()) {

                String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                // Set parameters BEFORE executing
                stmt.setInt(1, emp.getEmployeeId());
                stmt.setString(2, emp.getFirstName());
                stmt.setString(3, emp.getLastName());
                stmt.setString(4, emp.getEmail());
                stmt.setString(5, emp.getPhoneNumber());
                stmt.setDate(6, new java.sql.Date(emp.getHireDate().getTime()));
                stmt.setString(7, emp.getJobTitle());
                stmt.setDouble(8, emp.getSalary());
                stmt.setInt(9, emp.getManagerId());
                stmt.setInt(10, emp.getDepartmentId());

                int rowUpdate = stmt.executeUpdate();  // Only this is needed

                if (rowUpdate != 1) {
                    throw new RuntimeException("Some SQL error occurred");
                }

                return emp;
            }
  
        }
       public boolean deleteEmployee(int empid) throws SQLException{
    	   try (Connection connection = DBConnection.getConnection()) {

               String sql = "DELETE FROM employee where emp id=?";
               PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, empid);
        int rowUpdated=stmt.executeUpdate();
        if(rowUpdated!=1) {
        	throw new RuntimeException("some sql error occured");
        }
        else {
        	return true;
        }
        }
       }
    public static void main(String[] args) {
        EmployeeDao emp = new EmployeeDao();
        try (Scanner sc = new Scanner(System.in)) {
        	emp.printAllEmployees();
            System.out.println("\nSearch Employee By ID:");
            int eid = sc.nextInt();
            emp.getEmployeeById(eid);
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }
}