package com.carlos.rewardsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.rewardsapp.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
