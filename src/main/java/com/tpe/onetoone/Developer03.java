package com.tpe.onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_developer3")
public class Developer03 {
    @Id
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(unique = true)
    private String email;

    private String branch;

    //her dev e bir bilgisayar
    //dev e hangi bilgisayarın verildiğini kaydetmek istiyorum
    @OneToOne
    @JoinColumn(name = "c_id")
    private Computer computer;


    public Developer03() {
    }

    public Developer03(Long id, String name, String email, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
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

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Developer03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", computer=" + computer +
                '}';
    }
}
