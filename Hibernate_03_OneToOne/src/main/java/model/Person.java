package model;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;

@Entity
@Table(name = "Tb_Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Person_ID")
    private int id;
    @Column(name = "Person_Name", columnDefinition = "NVARCHAR(20)")
    private String name;

    @OneToOne
    @JoinColumn(name = "Spouse")
    private Person spouse;

    public Person() {
    }

    public Person(String name, Person spouse) {
        this.name = name;
        this.spouse = spouse;
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

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        String spouseName = (spouse != null) ? spouse.getName() : "None";  // Xử lý giá trị null cho spouse
        return String.format("Id: %-2d || Name: %-20s || Spouse: %-20s", id, name, spouseName);
    }

}
