package com.example.customermanagement.domain.model;

import com.example.customermanagement.domain.model.valueobjects.TotalReservations;
import com.example.sharedkernel.domain.models.AbstractEntity;
import com.example.sharedkernel.domain.valueobjects.Address;
import com.example.sharedkernel.domain.valueobjects.Phone;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class Customer extends AbstractEntity<CustomerID> {
    private String name;
    private Phone phoneNumber;
    private Address address;
    private TotalReservations numOfReservations;

    private Customer(){
        super(CustomerID.randomId(CustomerID.class));
    }

    private Customer(CustomerID id){
        super(id);
    }

    public static Customer build(String name, Phone phoneNumber, Address address,TotalReservations numOfReservations){
        Customer customer = new Customer();
        customer.name = name;
        customer.phoneNumber = phoneNumber;
        customer.address = address;
        customer.numOfReservations = numOfReservations;
        return customer;
    }

    public static Customer build(String id, String name, Phone phoneNumber, Address address, TotalReservations numOfReservations){
        Customer customer = new Customer(new CustomerID(id));
        customer.name = name;
        customer.phoneNumber = phoneNumber;
        customer.address = address;
        customer.numOfReservations = numOfReservations;
        return customer;
    }


}
