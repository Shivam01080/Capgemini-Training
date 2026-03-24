package com.gal.controller;

import com.gal.entities.Issue;
import com.gal.service.IssueService;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private static final Logger log = LoggerFactory.getLogger(IssueController.class);

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public Issue createIssue(@RequestBody Issue issue) {
        log.info("Creating new issue");
        return issueService.createIssue(issue);
    }

    @GetMapping("/employee/{id}/unresolved")
    public List<Issue> getUnresolved(@PathVariable Long id) {
        log.info("Fetching unresolved issues for employee {}", id);
        return issueService.getUnresolvedIssues(id);
    }

    @GetMapping("/this-month")
    public List<Issue> getThisMonthIssues() {
        log.info("Fetching issues of current month");
        return issueService.getIssuesThisMonth();
    }

    @GetMapping("/employees/this-month")
    public List<String> getEmployeeNames() {
        log.info("Fetching employee names with issues this month");
        return issueService.getEmployeeNamesThisMonth();
    }
}