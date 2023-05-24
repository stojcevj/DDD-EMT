package com.example.reservationmanagment.models.modelID;

import com.example.sharedkernel.domain.models.DomainObjectId;

public class LocationID extends DomainObjectId {
    private LocationID(){
        super(LocationID.randomId(LocationID.class).getId());
    }

    public LocationID(String uuid){
        super(uuid);
    }
}
