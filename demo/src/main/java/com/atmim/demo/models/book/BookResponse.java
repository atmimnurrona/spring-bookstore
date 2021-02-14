package com.atmim.demo.models.book;

import com.atmim.demo.models.category.CategoryModel;

public class BookResponse {

    private Integer id;

    private String title;

    private String author;

    private Integer stock;

    private CategoryModel category;

    public BookResponse() {
    }

    public BookResponse(Integer id, String title, String author, Integer stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }
}
