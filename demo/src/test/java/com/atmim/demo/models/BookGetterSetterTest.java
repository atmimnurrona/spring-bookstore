package com.atmim.demo.models;

import com.atmim.demo.models.book.BookElement;
import com.atmim.demo.models.book.BookRequest;
import com.atmim.demo.models.book.BookResponse;
import com.atmim.demo.models.book.BookSearch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookGetterSetterTest {

    @Test
    void BookElementGetSet() {
        BookElement expected = new BookElement();
        expected.setId(1);
        expected.setTitle("xyz");
        expected.setAuthor("XYZ");
        expected.setStock(1);

        BookElement actual = new BookElement();
        actual.setId(1);
        actual.setTitle("xyz");
        actual.setAuthor("XYZ");
        actual.setStock(1);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getStock(), actual.getStock());
    }

    @Test
    void BookRequestGetSet() {
        BookRequest expected = new BookRequest();
        expected.setTitle("xyz");
        expected.setAuthor("XYZ");
        expected.setStock(1);

        BookRequest actual = new BookRequest();
        actual.setTitle("xyz");
        actual.setAuthor("XYZ");
        actual.setStock(1);

        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getStock(), actual.getStock());
    }

    @Test
    void BookResponseGetSet() {
        BookResponse expected = new BookResponse();
        expected.setId(1);
        expected.setTitle("xyz");
        expected.setAuthor("XYZ");
        expected.setStock(1);

        BookResponse actual = new BookResponse();
        actual.setId(1);
        actual.setTitle("xyz");
        actual.setAuthor("XYZ");
        actual.setStock(1);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getStock(), actual.getStock());
    }

    @Test
    void BookSearchGetSet() {
        BookSearch expected = new BookSearch();
        expected.setTitle("xyz");

        BookElement actual = new BookElement();
        actual.setTitle("xyz");

        assertEquals(expected.getTitle(), actual.getTitle());
    }
}
