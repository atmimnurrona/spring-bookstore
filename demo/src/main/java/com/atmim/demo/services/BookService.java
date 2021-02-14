package com.atmim.demo.services;

import com.atmim.demo.entities.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService extends CommonService<Book, Integer> {

}
