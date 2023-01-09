package com.tpe.onetomany_uni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company2 {

    @Id
    private Long id;

    @Column(unique = true)
    private String companyname;

    //companyde çalışan devleri görmek istersek
    @OneToMany
    @JoinColumn(name ="company_id")//dev table ında bir fk oluşturur.
    //join column kullanmazsak join table üretilir.
    private Set<Developer05> devs=new HashSet<>();

    public Company2() {
    }

    public Company2(Long id, String companyname) {
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

    public Set<Developer05> getDevs() {
        return devs;
    }

    public void setDevs(Set<Developer05> devs) {
        this.devs = devs;
    }

    @Override
    public String toString() {
        return "Company2{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                '}';
    }
}
