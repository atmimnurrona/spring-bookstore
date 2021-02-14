package com.atmim.demo.models.transaction;

import com.atmim.demo.entities.UserInfo;
import com.atmim.demo.models.book.BookElement;

public class TransactionResponse {
    private Integer id;

    private UserInfo userId;

    private BookElement bookId;

    private Integer price;

    private Integer tax;

    private Integer totalPayment;

    public TransactionResponse() {
    }

    public TransactionResponse(Integer id, UserInfo userId, BookElement bookId, Integer price, Integer tax, Integer totalPayment) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.price = price;
        this.tax = tax;
        this.totalPayment = totalPayment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserInfo getUserId() {
        return userId;
    }

    public void setUserId(UserInfo userId) {
        this.userId = userId;
    }

    public BookElement getBookId() {
        return bookId;
    }

    public void setBookId(BookElement bookId) {
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
