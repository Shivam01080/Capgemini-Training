package com.gal.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gal.dao.EmployeeRepository;
import com.gal.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee find(int empId) {
        return employeeRepository.findById(empId).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee add(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void delete(int empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public Employee update(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee findByFirstname(String firstname) {
        return employeeRepository.findByFirstname(firstname);
    }

    @Override
    public Employee findByLastname(String lastname) {
        return employeeRepository.findByLastname(lastname);
    }

	@Override
	public List<Employee> findByCabnoAndBookingDate(String cabno, Date bookingDate) {
		
		return null;
	}

    
    
}