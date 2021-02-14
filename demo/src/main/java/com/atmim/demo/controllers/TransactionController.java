package com.atmim.demo.controllers;

import com.atmim.demo.entities.Book;
import com.atmim.demo.entities.Transaction;
import com.atmim.demo.entities.UserInfo;
import com.atmim.demo.exceptions.EntityNotFoundException;
import com.atmim.demo.models.PagedList;
import com.atmim.demo.models.ResponseMessage;
import com.atmim.demo.models.transaction.TransactionElement;
import com.atmim.demo.models.transaction.TransactionRequest;
import com.atmim.demo.models.transaction.TransactionResponse;
import com.atmim.demo.models.transaction.TransactionSearch;
import com.atmim.demo.services.BookService;
import com.atmim.demo.services.TransactionService;
import com.atmim.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/transactions")
@RestController
public class TransactionController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<TransactionResponse> add(
            @RequestBody @Valid TransactionRequest model) {
        Transaction entity = modelMapper.map(model, Transaction.class);

        UserInfo userId = userService.findById(model.getUserId());
        entity.setUserId(userId);

        Book book = bookService.findById(model.getBookId());
        entity.setBookId(book);

        book.setStock(book.getStock() - model.getQuantity());

        entity.setPrice(book.getCategory().getFee());
        entity.setTax(book.getCategory().getFee() * 10 / 100);
        entity.setTotalPayment((entity.getPrice() * model.getQuantity()) + entity.getTax());

        entity = transactionService.save(entity);

        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<TransactionResponse> edit(
            @PathVariable Integer id, @RequestBody TransactionRequest model) {
        Transaction entity = transactionService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        Book book = bookService.findById(model.getBookId());
        entity.setBookId(book);

        modelMapper.map(model, entity);
        entity = transactionService.save(entity);

        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("{id}")
    public ResponseMessage<TransactionResponse> removeById(@PathVariable Integer id) {
        Transaction entity = transactionService.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<TransactionResponse> findById(
            @PathVariable("id") Integer id) {

        Transaction entity = transactionService.findById(id);
        if (entity != null) {
            TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
            return ResponseMessage.success(data);
        }
        throw new EntityNotFoundException();
    }

    @GetMapping
    public ResponseMessage<PagedList<TransactionElement>> findAll(
            @Valid TransactionSearch model
    ) {
        Transaction search = modelMapper.map(model, Transaction.class);

        Page<Transaction> entityPage = transactionService.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Transaction> entities = entityPage.toList();

        List<TransactionElement> models = entities.stream()
                .map(e -> modelMapper.map(e, TransactionElement.class))
                .collect(Collectors.toList());

        PagedList<TransactionElement> data = new PagedList<>(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }
}
