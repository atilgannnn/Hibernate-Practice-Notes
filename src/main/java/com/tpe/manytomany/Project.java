package com.tpe.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {
    @Id
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_dev", joinColumns = @JoinColumn(name = "project_id"),
                                      inverseJoinColumns = @JoinColumn(name = "dev_id"))
    private Set<Developer07> developers=new HashSet<>();

    public Project() {
    }

    public Project(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Developer07> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer07> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
