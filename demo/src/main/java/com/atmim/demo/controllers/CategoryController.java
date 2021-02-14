package com.atmim.demo.controllers;

import com.atmim.demo.entities.Category;
import com.atmim.demo.exceptions.EntityNotFoundException;
import com.atmim.demo.models.PagedList;
import com.atmim.demo.models.ResponseMessage;
import com.atmim.demo.models.category.CategoryModel;
import com.atmim.demo.models.category.CategorySearch;
import com.atmim.demo.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/categories")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<CategoryModel> add(@RequestBody @Valid CategoryModel model) {
        Category entity = modelMapper.map(model, Category.class);
        entity = service.save(entity);

        CategoryModel data = modelMapper.map(entity, CategoryModel.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<CategoryModel> edit(@PathVariable Integer id, @RequestBody Category model) {
        Category entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        modelMapper.map(model, entity);
        entity = service.save(entity);

        CategoryModel data = modelMapper.map(entity, CategoryModel.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("{id}")
    public ResponseMessage<CategoryModel> removeById(@PathVariable Integer id) {
        Category entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        CategoryModel data = modelMapper.map(entity, CategoryModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<CategoryModel> findById(@PathVariable("id") Integer id) {
        Category entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        CategoryModel data = modelMapper.map(entity, CategoryModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PagedList<CategoryModel>> findAll(
            @Valid CategorySearch model
    ) {
        Category search = modelMapper.map(model, Category.class);

        Page<Category> entityPage = service.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Category> entities = entityPage.toList();

        List<CategoryModel> models = entities.stream()
                .map(e -> modelMapper.map(e, CategoryModel.class))
                .collect(Collectors.toList());

        PagedList<CategoryModel> data = new PagedList<>(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

}
