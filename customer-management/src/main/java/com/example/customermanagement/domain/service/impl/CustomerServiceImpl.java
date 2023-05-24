package com.example.customermanagement.domain.service.impl;

import com.example.customermanagement.domain.model.Customer;
import com.example.customermanagement.domain.model.CustomerID;
import com.example.customermanagement.domain.model.valueobjects.TotalReservations;
import com.example.customermanagement.domain.repository.CustomerRepository;
import com.example.customermanagement.domain.service.CustomerService;
import com.example.customermanagement.domain.service.form.CustomerForm;
import com.example.sharedkernel.domain.valueobjects.Address;
import com.example.sharedkernel.domain.valueobjects.Phone;
import org.springframework.stereotype.Service;

import javax.management.InvalidAttributeValueException;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> addCustomer(CustomerForm c) {
        Customer customer = Customer.build(c.getName(), c.getPhoneNumber(), c.getAddress(), c.getTotalReservations());
        return Optional.of(customerRepository.saveAndFlush(customer));
    }

    @Override
    public Optional<Customer> addCustomer(String id, String name, Phone phone, Address address, TotalReservations totalReservations) {
        Customer customer = Customer.build(id,name,phone,address,totalReservations);
        return Optional.of(customerRepository.saveAndFlush(customer));
    }

    @Override
    public void deleteCustomer(CustomerID id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(CustomerID id) {
        return customerRepository.findById(id);
    }

    @Override
    public void increaseReservations(CustomerID id) throws InvalidAttributeValueException {
        Customer customer = customerRepository.findById(id).orElseThrow(InvalidAttributeValueException::new);
        customer.getNumOfReservations().increase();
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void decreaseReservations(CustomerID id) throws InvalidAttributeValueException {
        Customer customer = customerRepository.findById(id).orElseThrow(InvalidAttributeValueException::new);
        customer.getNumOfReservations().decrease();
        customerRepository.saveAndFlush(customer);
    }

}
