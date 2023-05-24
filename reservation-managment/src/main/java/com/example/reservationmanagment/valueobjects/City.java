package com.example.reservationmanagment.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class City implements ValueObject {
    private final String city;

    public City(){
        this.city = "";
    }


    public City(String city) {
        this.city = city;
    }
}
