package com.example.customermanagement.domain.repository;

import com.example.customermanagement.domain.model.Customer;
import com.example.customermanagement.domain.model.CustomerID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, CustomerID> {
}
