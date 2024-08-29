package model;

import jakarta.persistence.Entity;

import java.sql.Date;
@Entity
public class Student extends Person{
    private double score;
    private int semester;

    public Student() {
    }

    public Student(String id, String name, Date dob, double score, int semester) {
        super(id, name, dob);
        this.score = score;
        this.semester = semester;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
