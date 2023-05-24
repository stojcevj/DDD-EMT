package com.example.reservationmanagment.valueobjects;

import com.example.sharedkernel.domain.models.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class RatingID extends DomainObjectId {
    private RatingID(){
        super(RatingID.randomId(RatingID.class).getId());
    }

    public RatingID(String uuid){
        super(uuid);
    }
}
