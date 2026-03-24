package com.gal.service;

import java.util.List;

import com.gal.model.Department;

public interface DepartmentService {

    Department find(int departmentId);

    List<Department> findAll();

    void delete(int departmentId);
    
    Department findByName(String name);

	Department addDepartment(Department department);

	Department update(Department department);
}