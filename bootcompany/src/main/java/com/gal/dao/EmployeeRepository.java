package com.gal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gal.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByFirstname(String firstname);

    Employee findByLastname(String lastname);

}
