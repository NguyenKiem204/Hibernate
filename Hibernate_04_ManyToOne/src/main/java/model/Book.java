package model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @Column(name = "Book_ID")
    private String id;
    @Column(name = "Book_Title", columnDefinition = "NVARCHAR(50)")
    private String title;
    @Column(name = "Book_Price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "Author")
    private Author author;

    public Book() {
    }

    public Book(String id, String title, double price, Author author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
