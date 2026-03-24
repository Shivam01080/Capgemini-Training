package com.gal.api;

import com.gal.model.Employee;
import com.gal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/transport")
public class EmployeeTransportController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/bookingDate")
    public List<Employee> getEmployeesByCabAndDate( @RequestParam String cabno,@RequestParam String date){  
          Date bookingDate = Date.valueOf(date); 
        return employeeService.findByCabnoAndBookingDate(cabno, bookingDate);
    }
}