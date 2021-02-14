package com.atmim.demo.services.implement;

import com.atmim.demo.entities.Transaction;
import com.atmim.demo.repositories.TransactionRepository;
import com.atmim.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends CommonServiceImpl<Transaction, Integer> implements TransactionService {
    @Autowired
    protected TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }
}
