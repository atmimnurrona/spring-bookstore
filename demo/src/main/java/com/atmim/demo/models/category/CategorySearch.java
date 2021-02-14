package com.atmim.demo.models.category;

import com.atmim.demo.models.PageSearch;
import com.atmim.demo.models.validations.Alphabetic;

public class CategorySearch extends PageSearch {

    @Alphabetic
    private String name;

    private String shelf_code;

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
}
