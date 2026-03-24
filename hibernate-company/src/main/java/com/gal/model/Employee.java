package com.gal.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name ="employee")
public class Employee {

    private Date hire_date;
    private double salary;
    @Id
    private Integer employee_id;
    private Integer manager_id;
    private Integer department_id;
    private String phone_number;
    private String first_name;
    private String last_name;
    private String email;
    private String job_title;
    

    // ✅ Constructor
    public Employee(Date hireDate,
                    Double salary,
                    int employeeId,
                    Integer managerId,
                    Integer departmentId,
                    String phoneNumber,
                    String firstName,
                    String lastName,
                    String email,
                    String jobTitle) {

        this.hire_date = hireDate;
        this.salary = salary;
        this.employee_id = employeeId;
        this.manager_id = managerId;
        this.department_id = departmentId;
        this.phone_number = phoneNumber;
        this.first_name = firstName;
        this.last_name = lastName;
        this.email = email;
        this.job_title = jobTitle;
    }

    // Optional default constructor
    public Employee() {
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }
}