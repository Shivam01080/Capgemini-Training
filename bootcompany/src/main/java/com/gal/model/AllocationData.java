package com.gal.model;

import java.sql.Date;
import java.util.List;

public class AllocationData {

    private List<Integer> employees;
    private int cabId;
    private Date allocDate;
    public List<Integer> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Integer> employees) {
        this.employees = employees;
    }
    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }
    public Date getAllocDate() {
        return allocDate;
    }

    public void setAllocDate(Date allocDate) {
        this.allocDate = allocDate;
    }
}