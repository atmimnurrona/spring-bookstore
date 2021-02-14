package com.atmim.demo.entities;

import javax.persistence.*;

@Entity
public class Category extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String shelf_code;

    @Column
    private Integer fee;

    public Category() {
    }

    public Category(String name, String shelf_code, Integer fee) {
        this.name = name;
        this.shelf_code = shelf_code;
        this.fee = fee;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shelf_code='" + shelf_code + '\'' +
                ", fee=" + fee +
                '}';
    }
}
