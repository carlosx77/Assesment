package com.carlos.rewardsapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carlos.rewardsapp.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query(value = "SELECT t FROM Transaction t WHERE t.customer.id = :customerId AND t.timestamp BETWEEN :startDate AND :endDate ORDER BY t.timestamp ASC", nativeQuery = false)
    List<Transaction> findByCustomerIdAndYear(@Param("customerId") Long customerId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
