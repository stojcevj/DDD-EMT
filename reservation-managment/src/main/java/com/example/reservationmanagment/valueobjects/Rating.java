package com.example.reservationmanagment.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;
import com.example.sharedkernel.domain.valueobjects.Rate;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class Rating implements ValueObject {
    private final Rate rate;
    private final RatingID ratingId;

    private Rating(){
        this.ratingId = RatingID.randomId(RatingID.class);
        this.rate = Rate.of(0);
    }

    @JsonCreator
    public Rating(Rate rate, RatingID ratingId){
        this.rate = rate;
        this.ratingId = ratingId;
    }

}
