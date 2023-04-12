package com.carlos.rewardsapp.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.carlos.rewardsapp.dao.TransactionsDAO;
import com.carlos.rewardsapp.entities.Customer;
import com.carlos.rewardsapp.entities.Transaction;
import com.carlos.rewardsapp.repository.CustomerRepository;
import com.carlos.rewardsapp.repository.TransactionRepository;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TransactionsDAOTest {

    @Autowired
    private TransactionsDAO transactionsDAO;

    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired CustomerRepository customerRepository;

    @Test
    public void testFindByCustomerIdAndYear() {
    	
        List<Transaction> transactions = transactionsDAO.findByCustomerIdAndYear(2L, 2022);

        assertEquals(7, transactions.size());

        for (Transaction transaction : transactions) {
            assertEquals(Long.valueOf(2), transaction.getCustomer().getId());
            assertEquals(2022, transaction.getTimestamp().getYear());
        }
    }

}