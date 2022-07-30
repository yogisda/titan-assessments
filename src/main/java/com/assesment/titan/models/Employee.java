package com.assesment.titan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "department")
    private String department;
    @Column(name = "birthdate")
    private String birthdate;
    @Column(name = "costcenter")
    private String costcenter;

    public Employee() {
    }

    public Employee(long id, String firstname, String lastname, String department, String birthdate, String costcenter) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.birthdate = birthdate;
        this.costcenter = costcenter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCostcenter() {
        return costcenter;
    }

    public void setCostcenter(String costcenter) {
        this.costcenter = costcenter;
    }
}


