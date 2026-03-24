package com.gal.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Department {

    @Id
    @Column(name = "department_id")
    private int departmentid;

    @Column(name = "department_name")
    private String depname;

    @Column(name = "manager_id")
    private Integer managerid;
    @Column(name = "established_date")
    private Date establishedDate;
    public Department() {
		
	}
    public Department(int departmentid, String depname, int managerId, Date establishedDate) {
        this.departmentid = departmentid;
        this.depname = depname;
        this.managerid = managerid;
        this.establishedDate = establishedDate;
    }
	public Date getEstablishedDate() {
        return establishedDate;
    }
    public void setEstablishedDate(Date date) {
        this.establishedDate = date;
    }

    @Override
    public String toString() {
        return "Department [departmentId=" + departmentid +
               ", depName=" + depname +
               ", managerId=" + managerid +
               ", establishedDate=" + establishedDate + "]";
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }
}