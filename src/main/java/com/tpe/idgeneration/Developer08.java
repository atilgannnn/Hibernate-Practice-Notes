package com.tpe.idgeneration;

import javax.persistence.*;

@Entity
public class Developer08 {


    @Id
    @SequenceGenerator(name = "sequence",sequenceName = "dev8_seq",initialValue = 100,allocationSize = 5)
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String email;

    private String branch;

    public Developer08() {
    }

    public Developer08(String name, String email, String branch) {
        this.name = name;
        this.email = email;
        this.branch = branch;
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
}
