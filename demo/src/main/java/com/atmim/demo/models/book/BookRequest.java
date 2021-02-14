package com.atmim.demo.models.book;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookRequest {
    @Size(min = 1, max = 100)
    private String title;

    @NotNull
    private Integer categoryId;

    @Size(min = 1, max = 100)
    private String author;

    @NotNull
    private Integer stock;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
