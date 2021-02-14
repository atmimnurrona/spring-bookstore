package com.atmim.demo.models;

import com.atmim.demo.entities.UserInfo;
import com.atmim.demo.models.book.BookElement;
import com.atmim.demo.models.book.BookResponse;
import com.atmim.demo.models.transaction.TransactionElement;
import com.atmim.demo.models.transaction.TransactionRequest;
import com.atmim.demo.models.transaction.TransactionResponse;
import com.atmim.demo.models.transaction.TransactionSearch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TransactionGetterSetterTest {

    private TransactionElement element;
    private TransactionRequest request;
    private TransactionResponse response;
    private TransactionSearch search;
    private BookElement book;
    private BookResponse bookResponse;
    private UserInfo userInfo;

    @Test
    void setTransactionElementGetSet() {

        TransactionElement expected = new TransactionElement();
        expected.setId(1);
        expected.setBookId(book);
        expected.setUserId(userInfo);

        TransactionElement actual = new TransactionElement();
        actual.setId(1);
        actual.setBookId(book);
        actual.setUserId(userInfo);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getBookId(), actual.getBookId());
        assertEquals(expected.getUserId(), actual.getUserId());

    }
}
