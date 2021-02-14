package com.atmim.demo.models.category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryModel {

    private Integer id;

    @NotBlank
    @Size(min=1, max=100)
    private String name;

    @NotBlank
    @Size(min=1, max=100)
    private String shelf_code;

    @NotBlank
    private Integer fee;

    public CategoryModel() {
    }

    public CategoryModel(Integer id, String name, String shelf_code, Integer fee) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShelf_code() {
        return shelf_code;
    }

    public void setShelf_code(String shelf_code) {
        this.shelf_code = shelf_code;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }
}

