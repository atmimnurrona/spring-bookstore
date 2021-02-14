package com.atmim.demo.services.implement;

import com.atmim.demo.entities.Category;
import com.atmim.demo.repositories.CategoryRepository;
import com.atmim.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends CommonServiceImpl<Category, Integer> implements CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }
}
