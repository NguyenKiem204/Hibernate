package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;
@Entity
public class Author {  // Nên tạo mối quan hệ 1 trước
    @Id
    @Column(name = "Author_ID")
    private String id;
    @Column(name = "Author_Name", columnDefinition = "NVARCHAR(30)")
    private String name;
    @Column(name = "DateOfBirth")
    private Date dob;

    public Author() {
    }

    public Author(String id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
