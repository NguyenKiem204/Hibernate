package model;

import jakarta.persistence.*;

@Entity
@Table(name = "My_Order")
public class My_Order {
    @Id
    @Column(name = "Order_ID")
    private String id;
    @Column(name = "Address", columnDefinition = "NVARCHAR(50)")
    private String address;

    @ManyToOne
    @JoinColumn(name = "Customer_ID")
    private Customer customer;

    public My_Order() {
    }

    public My_Order(String id, String address, Customer customer) {
        this.id = id;
        this.address = address;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", customer=" + customer +
                '}';
    }
}
