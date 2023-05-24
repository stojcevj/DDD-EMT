package com.example.customermanagement.domain.model;

import com.example.sharedkernel.domain.models.DomainObjectId;
import lombok.Getter;

@Getter
public class CustomerID extends DomainObjectId {
    private CustomerID(){
        super(CustomerID.randomId(CustomerID.class).getId());
    }

    public CustomerID(String uuid){
        super(uuid);
    }
}