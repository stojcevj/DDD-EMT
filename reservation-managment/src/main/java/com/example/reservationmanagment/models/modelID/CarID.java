package com.example.reservationmanagment.models.modelID;

import com.example.sharedkernel.domain.models.DomainObjectId;

public class CarID extends DomainObjectId {
    private CarID(){
        super(CarID.randomId(CarID.class).getId());
    }

    public CarID(String uuid){
        super(uuid);
    }
}
