package com.gal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gal.model.Employee;
import com.gal.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // by ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.find(id);
    }

    // first name
    @GetMapping("/byfirstname")
    public Employee getEmployeeByFirstName(@RequestParam String firstname) {
        return employeeService.findByFirstname(firstname);
    }

    //last name
    @GetMapping("/bylastname")
    public Employee getEmployeeByLastName(@RequestParam String lastname) {
        return employeeService.findByLastname(lastname);
    }
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }
}