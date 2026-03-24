package com.gal.service;

import com.gal.dao.CabAllocationRepo;
import com.gal.dao.CabRepo;
import com.gal.dao.EmployeeRepository;
import com.gal.model.AllocationData;
import com.gal.model.Cab;
import com.gal.model.CabAllocation;
import com.gal.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AllocationServiceImp {

    @Autowired
    private CabRepo cabRepo;

    @Autowired
    private CabAllocationRepo cabAllocationRepo;

    @Autowired
    private EmployeeRepository empRepo;
    @Transactional
    public List<CabAllocation> allocate(AllocationData allocData) {

        List<Integer> empList = allocData.getEmployees();
        int cabid = allocData.getCabId();
        Date aldate = allocData.getAllocDate();

        Cab cab = cabRepo.findById(cabid)
                .orElseThrow(() -> new RuntimeException("Cab not found"));

        List<CabAllocation> allocationList = new ArrayList<>();

        for (int empid : empList) {

            Employee emp = empRepo.findById(empid)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

            CabAllocation caballo = new CabAllocation();
            caballo.setEmployee(emp);
            caballo.setCab(cab);
            caballo.setBookingDate(aldate);  

            cabAllocationRepo.save(caballo);
            allocationList.add(caballo);
        }

        return allocationList;
    }
    public List<CabAllocation> getByCabAndDate(int cabId, Date date) {
        return cabAllocationRepo.findByCab_CabidAndBookingDate(cabId, date);
    }
}