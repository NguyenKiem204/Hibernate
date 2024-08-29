package model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Course_ID")
    private int id;
    @Column(name = "Course_Name", columnDefinition = "NVARCHAR(50)")
    private String name;
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
