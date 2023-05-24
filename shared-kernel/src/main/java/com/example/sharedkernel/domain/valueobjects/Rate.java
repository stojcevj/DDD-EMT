package com.example.sharedkernel.domain.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Rate implements ValueObject {
    private final Integer rating;

    public Rate(){
        this.rating = 0;
    }

    public Rate(Integer rate){
        this.rating = rate;
    }
    public static Rate of(Integer rate){
        return new Rate(rate);
    }
}
