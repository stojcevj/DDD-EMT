package com.example.reservationmanagment.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;
import com.example.sharedkernel.domain.valueobjects.Address;
import com.example.sharedkernel.domain.valueobjects.Phone;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class Customer implements ValueObject {
    private final CustomerID customerID;
    private final String name;
    private final Phone phoneNumber;
    private final Address address;

    private Customer(){
        this.customerID = CustomerID.randomId(CustomerID.class);
        this.name = "";
        this.phoneNumber = Phone.of("");
        this.address = Address.of("",0);
    }

    @JsonCreator
    public Customer(CustomerID customerID, String name, Phone phoneNumber, Address address){
        this.customerID = customerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
