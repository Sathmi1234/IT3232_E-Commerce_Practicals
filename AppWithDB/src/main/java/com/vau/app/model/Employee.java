package com.vau.app.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Employee extends Person{
    @Id
    private String empId;
    private double salary;
    
    //@ManyToOne
    //@JsonBackReference
    //private Department department;
    
//    @ManyToMany(mappedBy = "employees")
//    @JsonBackReference  // Changed from @JsonManagedReference to @JsonBackReference
//    private List<Project> projects;
//    
//    @OneToOne(mappedBy="employee")
//    @JsonManagedReference
//    private Insurance insurance;
//    
    public Employee() {
        super();
    }
    
    public String getEmpId() {
        return empId;
    }
    
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
//    public Department getDepartment() {
//        return department;
//    }
//    
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
//    
//    public List<Project> getProjects() {
//        return projects;
//    }
//    
//    public void setProjects(List<Project> projects) {
//        this.projects = projects;
//    }
//    
//    public Insurance getInsurance() {
//        return insurance;
//    }
//    
//    public void setInsurance(Insurance insurance) {
//        this.insurance = insurance;
//    }
}