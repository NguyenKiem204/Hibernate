package model;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "sex")
    private Boolean sex;

    public Cat() {
    }

    public Cat(String name, Date dateOfBirth, Boolean sex) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    // Getter và Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("Id: %-3s || Name: %-6s || DoB: %-6s || Sex: %-3s ", getId(), getName(), getDateOfBirth(), getSex());
    }
}
