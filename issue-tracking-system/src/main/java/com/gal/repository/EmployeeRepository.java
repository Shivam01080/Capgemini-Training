package com.gal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gal.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}