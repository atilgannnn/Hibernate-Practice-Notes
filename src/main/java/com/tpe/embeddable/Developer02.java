package com.tpe.embeddable;

import javax.persistence.*;

@Entity
@Table(name="t_developer2")
public class Developer02 {

    @Id
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(unique = true)
    private String email;

    private String branch;

    @Embedded
    private Education education;

    public Developer02(Long id, String name, String email, String branch, Education education) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.education = education;
    }

    public Developer02() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Developer02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", education=" + education +
                '}';
    }
}
