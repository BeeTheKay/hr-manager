package models;

import util.HRManagerUtil;

import java.util.Date;

public class Employee {

    private String id;
    private String prename;
    private String surname;
    private String jobDescription;
    private Date birthdate;
    private Double salary;
    private Date employmentDate;

    public Employee() {
    }

    public Employee(String prename, String surname, String jobDescription, Date birthdate, Double salary, Date employmentDate) {
        this.id = HRManagerUtil.generateId();
        this.prename = prename;
        this.surname = surname;
        this.jobDescription = jobDescription;
        this.birthdate = birthdate;
        this.salary = salary;
        this.employmentDate = employmentDate;
    }

    //Getter & Setter

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getId() {
        return id;
    }

}
