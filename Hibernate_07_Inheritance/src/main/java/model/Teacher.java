package model;

import jakarta.persistence.Entity;

import java.sql.Date;
@Entity
public class Teacher extends Person{
    private String degree;
    private int yearsOfExperience;

    public Teacher() {
    }

    public Teacher(String id, String name, Date dob, String degree, int yearsOfExperience) {
        super(id, name, dob);
        this.degree = degree;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
