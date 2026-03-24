package com.gal.service;

import com.gal.entities.Issue;
import com.gal.enums.IssueStatus;
import com.gal.repository.IssueRepository;
import com.gal.service.IssueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;

    public IssueServiceImpl(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public List<Issue> getUnresolvedIssues(Long empId) {
        return issueRepository.findByEmployeeIdAndStatusNot(empId, IssueStatus.RESOLVED);
    }

    @Override
    public List<Issue> getIssuesThisMonth() {
        return issueRepository.findIssuesThisMonth();
    }

    @Override
    public List<String> getEmployeeNamesThisMonth() {
        return issueRepository.findEmployeeNamesThisMonth();
    }

    @Override
    public Issue createIssue(Issue issue) {
        return issueRepository.save(issue);
    }
}