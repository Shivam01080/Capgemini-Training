package com.gal.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.gal.dao.DepartmentRepository;
import com.gal.model.Department;

import jakarta.transaction.Transactional;

@Service
@Primary
public class DepartmentServiceImpl2 implements DepartmentService {
	private static final Logger Log = LoggerFactory.getLogger(DepartmentServiceImpl2.class);
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department find(int departmentId) {

        Optional<Department> op =
                departmentRepository.findById(departmentId);

        return op.orElseThrow();
    }

    @Override
    public List<Department> findAll() {

        return departmentRepository.findAll();
    }

    @Override
    @Transactional
    public Department addDepartment(Department department) {

        Department saved= departmentRepository.save(department);
        return saved;
    }

    @Override
    @Transactional
    public void delete(int departmentId) {

        departmentRepository.deleteById(departmentId);
    }

    @Override
    @Transactional
    public Department update(Department department) {
        Optional<Department> opt = departmentRepository.findById(department.getDepartmentid());

        if(opt.isEmpty()) {
            throw new RuntimeException("department not exist");
        }

        return departmentRepository.save(department);
    }
    
    @Override
    @Transactional
    public Department findByName(String name) {

        return departmentRepository.findByName(name);
    }
}