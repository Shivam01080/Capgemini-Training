package com.gal.dao;

import java.util.List;
import com.gal.model.Department;

public interface DepartmentDao {

    Department find(int depid);

    List<Department> findAll();

   Department add(Department department);

    void delete(int depid);

    void update(Department department);
}