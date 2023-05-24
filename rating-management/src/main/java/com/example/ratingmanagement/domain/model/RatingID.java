package com.example.ratingmanagement.domain.model;

import com.example.sharedkernel.domain.models.DomainObjectId;
import lombok.Getter;

@Getter
public class RatingID extends DomainObjectId {
    private RatingID(){
        super(RatingID.randomId(RatingID.class).getId());
    }

    public RatingID(String uuid){
        super(uuid);
    }
}
