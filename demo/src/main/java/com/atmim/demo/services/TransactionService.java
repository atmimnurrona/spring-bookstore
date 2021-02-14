package com.atmim.demo.services;

import com.atmim.demo.entities.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService extends CommonService<Transaction, Integer>{
}
