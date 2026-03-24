package com.gal.service;

import com.gal.entities.Issue;
import java.util.List;

public interface IssueService {

    List<Issue> getUnresolvedIssues(Long empId);

    List<Issue> getIssuesThisMonth();

    List<String> getEmployeeNamesThisMonth();

    Issue createIssue(Issue issue);
}