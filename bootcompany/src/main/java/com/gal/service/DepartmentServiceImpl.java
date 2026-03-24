package com.gal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gal.dao.DepartmentDao;
import com.gal.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Department find(int departmentId) {
        return departmentDao.find(departmentId);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public  Department addDepartment(Department department) {
       return departmentDao.add(department);
    }

    @Override
    public void delete(int departmentId) {
        departmentDao.delete(departmentId);
    }

    @Override
    public Department update(Department department) {
        departmentDao.update(department);
		return department;
    }

	@Override
	public Department findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}