package com.tpe.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    private Long id;

    @Column(unique = true)
    private String companyname;

    public Company() {
    }

    public Company(Long id, String companyname) {
        this.id = id;
        this.companyname = companyname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Override
    public String toString() {
        return "Company2{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                '}';
    }
}
