package com.carlos.rewardsapp.dao;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.rewardsapp.entities.Transaction;
import com.carlos.rewardsapp.repository.TransactionRepository;

@Component
public class TransactionsDAO {
	
	@Autowired
    TransactionRepository repository;
    
    public List<Transaction> findByCustomerIdAndYear(Long customerId, int year) {
    	return repository.findByCustomerIdAndYear(customerId, LocalDateTime.of(year, Month.JANUARY, 1, 0, 0, 0),LocalDateTime.of(year, Month.DECEMBER, 31, 23, 59, 59));
    }
}
