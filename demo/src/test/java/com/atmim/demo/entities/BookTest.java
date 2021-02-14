package com.atmim.demo.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookTest {

    @Mock
    private List<Transaction> transactions;

    @Mock
    private Category category;

    @Test
    void setBookEntity() {
        LocalDateTime now = LocalDateTime.now();

        Book expected = new Book();
        expected.setId(1);
        expected.setTitle("xyz");
        expected.setAuthor("XYZ");
        expected.setStock(1);
        expected.setCategory(category);
        expected.setCreatedDate(now);
        expected.setModifiedDate(now);

        Book actual = new Book();
        actual.setId(1);
        actual.setTitle("xyz");
        actual.setAuthor("XYZ");
        actual.setStock(1);
        actual.setCategory(category);
        actual.setCreatedDate(now);
        actual.setModifiedDate(now);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getStock(), actual.getStock());
        assertEquals(expected.getCategory(), actual.getCategory());
        assertEquals(expected.getCreatedDate(), actual.getCreatedDate());
        assertEquals(expected.getModifiedDate(), actual.getModifiedDate());

    }

}
