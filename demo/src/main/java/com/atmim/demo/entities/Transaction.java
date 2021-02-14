package com.atmim.demo.entities;

import javax.persistence.*;

@Entity
public class Transaction extends AbstractEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;

    @Column
    private Integer price;

    @Column
    private Integer quantity;

    @Column
    private Integer tax;

    @Column(name = "total_Payment")
    private Integer totalPayment;

    public Transaction() {
    }

    public Transaction(Integer id, UserInfo userId, Book bookId, Integer price, Integer tax, Integer totalPayment) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.price = price;
        this.tax = tax;
        this.totalPayment = totalPayment;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public UserInfo getUserId() {
        return userId;
    }

    public void setUserId(UserInfo userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Integer getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Integer totalPayment) {
        this.totalPayment = totalPayment;
    }

}
