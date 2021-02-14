package com.atmim.demo.services.implement;

import com.atmim.demo.entities.Book;
import com.atmim.demo.repositories.BookRepository;
import com.atmim.demo.services.BookService;
import com.atmim.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends CommonServiceImpl<Book, Integer> implements BookService {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        super(repository);
    }
}
