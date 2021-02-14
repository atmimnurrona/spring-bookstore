package com.atmim.demo.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TransactionTest {

    @Mock
    private Book book;

    @Mock
    private UserInfo userInfo;

    @Test
    void setTransactionEntity() {

        LocalDateTime now = LocalDateTime.now();

        Transaction expected = new Transaction();
        expected.setId(1);
        expected.setBookId(book);
        expected.setUserId(userInfo);
        expected.setCreatedDate(now);
        expected.setModifiedDate(now);
        expected.setTotalPayment(5000);
        expected.setTax(5000);
        expected.setPrice(3000);

        Transaction actual = new Transaction();
        actual.setId(1);
        actual.setBookId(book);
        actual.setUserId(userInfo);
        actual.setCreatedDate(now);
        actual.setModifiedDate(now);
        actual.setTotalPayment(5000);
        actual.setTax(5000);
        actual.setPrice(3000);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getBookId(), actual.getBookId());
        assertEquals(expected.getUserId(), actual.getUserId());
        assertEquals(expected.getCreatedDate(), actual.getCreatedDate());
        assertEquals(expected.getModifiedDate(), actual.getModifiedDate());
        assertEquals(expected.getTotalPayment(), actual.getTotalPayment());
        assertEquals(expected.getTax(), actual.getTax());
        assertEquals(expected.getPrice(), actual.getPrice());

    }
}
