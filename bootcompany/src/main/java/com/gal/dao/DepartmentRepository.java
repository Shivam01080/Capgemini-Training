package com.gal.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gal.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
	//HPL JPQL : SQL query with objects in mind
	//select * from department where department_name= :name
	//select d from Department d where d.depname= :name
	
	// @Query("from Department d where d.depname = :depname")
	@Query(value="select * from department d where d.department_name=:name",nativeQuery=true)
Department findByName(String name);	
	//find the latest department started
	@Query("FROM Department d WHERE d.establishedDate BETWEEN :st AND :end")
	List<Department> findByEstablishedDateBetween(@Param("st") LocalDate st,
	                                              @Param("end") LocalDate end);
	//find the department having no manager
List<Department> findByManageridIsNull();
	
	//find the department(s) whose managerid is given	
List<Department> findByManagerid(Integer managerid);
	//find the department(s) whose manager name is given
	
	
}
