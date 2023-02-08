package com.HotelManagement.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @Column(name = "feedbackid", nullable = false)
    private Integer id;

    @Column(name = "csmail", nullable = false, length = 50)
    private String csmail;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCsmail() {
        return csmail;
    }

    public void setCsmail(String csmail) {
        this.csmail = csmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}