package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class Customer {
    @Id
    @Column(name = "Customer_ID")
    private String id;
    @Column (name = "Customer_Name", columnDefinition = "NVARCHAR(50)")
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<My_Order> orders;

    public Customer() {
    }

    public Customer(String id, String name) {
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

    public List<My_Order> getOrders() {
        return orders;
    }

    public void setOrders(List<My_Order> orders) {
        this.orders = orders;
    }
}
