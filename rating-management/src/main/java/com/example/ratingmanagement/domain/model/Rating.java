package com.example.ratingmanagement.domain.model;

import com.example.sharedkernel.domain.models.AbstractEntity;
import com.example.sharedkernel.domain.valueobjects.Rate;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Rating extends AbstractEntity<RatingID> {
    private Rate rating;

    private Rating(){
        super(RatingID.randomId(RatingID.class));
    }

    public static Rating build(Rate rating){
        Rating r = new Rating();
        r.rating = rating;
        return r;
    }
}
