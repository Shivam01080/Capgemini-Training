package com.gal.repository;

import org.springframework.data.jpa.repository.*;

import com.gal.entities.Issue;
import com.gal.enums.IssueStatus;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {

    List<Issue> findByEmployeeIdAndStatusNot(Long empId, IssueStatus status);

    @Query("SELECT i FROM Issue i WHERE MONTH(i.createdAt)=MONTH(CURRENT_DATE) AND YEAR(i.createdAt)=YEAR(CURRENT_DATE)")
    List<Issue> findIssuesThisMonth();

    @Query("SELECT DISTINCT i.employee.name FROM Issue i WHERE MONTH(i.createdAt)=MONTH(CURRENT_DATE) AND YEAR(i.createdAt)=YEAR(CURRENT_DATE)")
    List<String> findEmployeeNamesThisMonth();
}