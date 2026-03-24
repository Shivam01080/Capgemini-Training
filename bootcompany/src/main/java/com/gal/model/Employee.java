package com.gal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @Column(name="employee_id")
    int employeeId;

    @Column(name="first_name")
    String firstname;

    @Column(name="last_name")
    String lastname;
    
   
    
    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId +
               ", firstname=" + firstname +
               ", lastname=" + lastname + "]";
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
}