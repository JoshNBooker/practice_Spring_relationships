package com.codeclan.employeetracker.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;

    @ManyToMany
    @JsonIgnoreProperties({"Projects"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "employee_projects",
            joinColumns = {
                    @JoinColumn(
                            name = "Project_id",
                            nullable = false,
                            updatable = false
                    ),
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "Employee_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Project> projects;
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonIgnoreProperties({"employees"})
    private Department department;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Employee(String first_name, String last_name, int age, String email, Department department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.email = email;
        this.department = department;
    }

    public Employee() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


