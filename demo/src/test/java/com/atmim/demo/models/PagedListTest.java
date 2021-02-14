package com.atmim.demo.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PagedListTest {

    private PagedList pagedList;

    @Test
    void setPagedList() {
        PagedList expected = new PagedList();
        expected.setPage(1);
        expected.setTotal(10l);
        expected.setSize(1);

        PagedList actual = new PagedList();
        actual.setPage(1);
        actual.setTotal(10l);
        actual.setSize(1);

        assertEquals(expected.getPage(), actual.getPage());
        assertEquals(expected.getTotal(), actual.getTotal());
        assertEquals(expected.getSize(), actual.getSize());

    }
}
