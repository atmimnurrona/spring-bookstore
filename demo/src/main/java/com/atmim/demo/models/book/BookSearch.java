package com.atmim.demo.models.book;

import com.atmim.demo.models.PageSearch;

public class BookSearch extends PageSearch {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
