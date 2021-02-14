package com.atmim.demo.controllers;

import com.atmim.demo.entities.Book;
import com.atmim.demo.entities.Category;
import com.atmim.demo.exceptions.EntityNotFoundException;
import com.atmim.demo.models.PagedList;
import com.atmim.demo.models.ResponseMessage;
import com.atmim.demo.models.book.BookElement;
import com.atmim.demo.models.book.BookRequest;
import com.atmim.demo.models.book.BookResponse;
import com.atmim.demo.models.book.BookSearch;
import com.atmim.demo.services.BookService;
import com.atmim.demo.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Add Book", description = "with the title..", tags = { "book" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseMessage.class))))
    })

    @PostMapping
    public ResponseMessage<BookResponse> add(@RequestBody @Valid BookRequest model) {
        Book entity = modelMapper.map(model, Book.class);

        Category category = categoryService.findById(model.getCategoryId());
        entity.setCategory(category);

        entity = bookService.save(entity);

        BookResponse data = modelMapper.map(entity, BookResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<BookResponse> edit(
            @PathVariable Integer id, @RequestBody BookRequest model) {
        Book entity = bookService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        Category category = categoryService.findById(model.getCategoryId());
        entity.setCategory(category);

        modelMapper.map(model, entity);
        entity = bookService.save(entity);

        BookResponse data = modelMapper.map(entity, BookResponse.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("{id}")
    public ResponseMessage<BookResponse> removeById(@PathVariable Integer id) {
        Book entity = bookService.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        BookResponse data = modelMapper.map(entity, BookResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<BookResponse> findById(@PathVariable("id") Integer id) {
        Book entity = bookService.findById(id);
        if (bookService.findById(id) != null) {
            BookResponse data = modelMapper.map(entity, BookResponse.class);
            return ResponseMessage.success(data);
        }
        throw new EntityNotFoundException();
    }

    @GetMapping
    public ResponseMessage<PagedList<BookElement>> findAll(
            @Valid BookSearch model
    ) {
        Book search = modelMapper.map(model, Book.class);

        Page<Book> entityPage = bookService.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Book> entities = entityPage.toList();

        List<BookElement> models = entities.stream()
                .map(e -> modelMapper.map(e, BookElement.class))
                .collect(Collectors.toList());

        PagedList<BookElement> data = new PagedList<>(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }
}
