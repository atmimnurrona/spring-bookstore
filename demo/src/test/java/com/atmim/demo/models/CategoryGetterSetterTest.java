package com.atmim.demo.models;

import com.atmim.demo.models.category.CategoryModel;
import com.atmim.demo.models.category.CategoryResponse;
import com.atmim.demo.models.category.CategorySearch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CategoryGetterSetterTest {

    @Test
    void CategoryModelGetSet() {
        CategoryModel expected = new CategoryModel();
        expected.setId(1);
        expected.setName("xyz");
        expected.setShelf_code("XYZ");
        expected.setFee(2000);

        CategoryModel actual = new CategoryModel();
        actual.setId(1);
        actual.setName("xyz");
        actual.setShelf_code("XYZ");
        actual.setFee(2000);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getShelf_code(), actual.getShelf_code());
        assertEquals(expected.getFee(), actual.getFee());
    }

    @Test
    void CategoryResponseGetSet() {
        CategoryModel expected = new CategoryModel();
        expected.setId(1);
        expected.setName("xyz");
        expected.setShelf_code("XYZ");
        expected.setFee(2000);

        CategoryModel actual = new CategoryModel();
        actual.setId(1);
        actual.setName("xyz");
        actual.setShelf_code("XYZ");
        actual.setFee(2000);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getShelf_code(), actual.getShelf_code());
        assertEquals(expected.getFee(), actual.getFee());
    }

    @Test
    void CategorySearchGetSet() {
        CategoryModel expected = new CategoryModel();
        expected.setName("xyz");
        expected.setShelf_code("XYZ");

        CategoryModel actual = new CategoryModel();
        actual.setName("xyz");
        actual.setShelf_code("XYZ");

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getShelf_code(), actual.getShelf_code());
    }
}
