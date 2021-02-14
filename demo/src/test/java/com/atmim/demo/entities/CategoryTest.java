package com.atmim.demo.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CategoryTest {

    @Mock
    private List<Book> book;

    @Test
    void setCategoryEntity() {
        LocalDateTime now = LocalDateTime.now();

        Category expected = new Category();
        expected.setId(1);
        expected.setName("xyz");
        expected.setShelf_code("XYZ");
        expected.setFee(2000);
        expected.setCreatedDate(now);
        expected.setModifiedDate(now);

        Category actual = new Category();
        actual.setId(1);
        actual.setName("xyz");
        actual.setShelf_code("XYZ");
        actual.setFee(2000);
        actual.setCreatedDate(now);
        actual.setModifiedDate(now);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getShelf_code(), actual.getShelf_code());
        assertEquals(expected.getFee(), actual.getFee());
        assertEquals(expected.getCreatedDate(), actual.getCreatedDate());
        assertEquals(expected.getModifiedDate(), actual.getModifiedDate());
    }
}
