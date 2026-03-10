package com.gal.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    private String title;
    private String client;
    private Date startDate;
    private Date endDate;
    private Double budget;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee projectManager;

    public Project() {}

    public Project(String title, String client,
                   Date startDate, Date endDate,
                   Double budget, Employee projectManager) {
        this.title = title;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.projectManager = projectManager;
    }

    // Getters & Setters

    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }

    public Employee getProjectManager() { return projectManager; }
    public void setProjectManager(Employee projectManager) { this.projectManager = projectManager; }
}