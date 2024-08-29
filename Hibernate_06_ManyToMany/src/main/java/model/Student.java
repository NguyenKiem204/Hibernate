package model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Student {
    @Id
    @Column(name = "Student_ID")
    private String id;
    @Column(name = "Student_name", columnDefinition = "NVARCHAR(50)")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Student_Course", joinColumns = @JoinColumn(name = "Student_ID"),
    inverseJoinColumns = @JoinColumn(name = "Course_ID"))
    private Set<Course> courses = new HashSet<>();

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
