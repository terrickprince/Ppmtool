package com.priraj.ppmtool.domain;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/***
 *
 */

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger projectId;
    private String projectName;
    private String projectIdentifier;
    private String projectDescription;
    private Date startDate;
    private Date endDate;
    private Date createdDate;
    private Date updatedDate;

    public Project(){

    }

    @PrePersist
    public void onCreate(){
        createdDate = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        updatedDate=new Date();
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
