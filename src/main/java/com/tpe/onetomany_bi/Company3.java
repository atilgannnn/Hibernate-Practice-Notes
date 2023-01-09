package com.tpe.onetomany_bi;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company3 {

    @Id
    private Long id;

    @Column(unique = true)
    private String companyname;

    //companyde çalışan devleri görmek istersek
    @OneToMany(mappedBy = "company",orphanRemoval = true)
    private Set<Developer06> devs=new HashSet<>();

    public Company3() {
    }

    public Company3(Long id, String companyname) {
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

    public Set<Developer06> getDevs() {
        return devs;
    }

    public void setDevs(Set<Developer06> devs) {
        this.devs = devs;
    }

    @Override
    public String toString() {
        return "Company3{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                '}';
    }
}
