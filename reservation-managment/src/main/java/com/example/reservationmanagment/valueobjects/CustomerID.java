package com.example.reservationmanagment.valueobjects;

import com.example.sharedkernel.domain.models.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerID extends DomainObjectId {

    private CustomerID(){
        super(CustomerID.randomId(CustomerID.class).getId());
    }

    public CustomerID(String uuid){
        super(uuid);
    }
}
