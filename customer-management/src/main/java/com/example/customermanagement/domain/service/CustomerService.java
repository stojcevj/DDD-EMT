package com.example.customermanagement.domain.service;

import com.example.customermanagement.domain.model.Customer;
import com.example.customermanagement.domain.model.CustomerID;
import com.example.customermanagement.domain.model.valueobjects.TotalReservations;
import com.example.customermanagement.domain.service.form.CustomerForm;
import com.example.sharedkernel.domain.valueobjects.Address;
import com.example.sharedkernel.domain.valueobjects.Phone;

import javax.management.InvalidAttributeValueException;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> addCustomer(CustomerForm c);
    void deleteCustomer(CustomerID id);
    List<Customer> findAll();
    Optional<Customer> findById(CustomerID id);
    Optional<Customer> addCustomer(String id, String name, Phone phone, Address address, TotalReservations totalReservations);
    void increaseReservations(CustomerID id) throws InvalidAttributeValueException;
    void decreaseReservations(CustomerID id) throws InvalidAttributeValueException;
}
