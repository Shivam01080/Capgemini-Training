package com.capg.issuetrackingsystem;

import com.gal.controller.IssueController;
import com.gal.entities.Issue;
import com.gal.enums.IssueCategory;
import com.gal.enums.IssueStatus;
import com.gal.service.IssueService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.gal")
public class IssueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IssueService issueService;

    @Test
    void testGetIssuesThisMonth() throws Exception {

        Issue issue1 = new Issue();
        issue1.setId(1L);
        issue1.setDescription("Laptop not working");
        issue1.setCategory(IssueCategory.DESKTOP);
        issue1.setStatus(IssueStatus.OPEN);

        Issue issue2 = new Issue();
        issue2.setId(2L);
        issue2.setDescription("Cloud access denied");
        issue2.setCategory(IssueCategory.CLOUD);
        issue2.setStatus(IssueStatus.IN_PROGRESS);

        List<Issue> issues = Arrays.asList(issue1, issue2);

        when(issueService.getIssuesThisMonth()).thenReturn(issues);

        mockMvc.perform(get("/issues/this-month"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].description").value("Laptop not working"))
                .andExpect(jsonPath("$[1].category").value("CLOUD"));
    }

    @Test
    void testGetUnresolvedIssues() throws Exception {

        Issue issue = new Issue();
        issue.setId(3L);
        issue.setDescription("VPN not working");
        issue.setCategory(IssueCategory.ACCESS_PERMISSION);
        issue.setStatus(IssueStatus.OPEN);

        when(issueService.getUnresolvedIssues(1L))
                .thenReturn(Collections.singletonList(issue));

        mockMvc.perform(get("/issues/employee/1/unresolved"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value("VPN not working"));
    }

    @Test
    void testGetEmployeeNames() throws Exception {

        List<String> names = Arrays.asList("Shivam", "Rahul");

        when(issueService.getEmployeeNamesThisMonth()).thenReturn(names);

        mockMvc.perform(get("/issues/employees/this-month"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("Shivam"))
                .andExpect(jsonPath("$[1]").value("Rahul"));
    }
}