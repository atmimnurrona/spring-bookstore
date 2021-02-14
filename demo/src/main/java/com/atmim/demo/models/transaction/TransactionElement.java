package com.atmim.demo.models.transaction;

import com.atmim.demo.entities.UserInfo;
import com.atmim.demo.models.book.BookElement;

public class TransactionElement {
    private Integer id;
    private UserInfo userId;
    private BookElement bookId;

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

}
