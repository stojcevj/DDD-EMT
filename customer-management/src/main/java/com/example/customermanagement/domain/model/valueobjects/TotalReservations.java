package com.example.customermanagement.domain.model.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class TotalReservations implements ValueObject {
    private Integer numOfReservations;

    public TotalReservations(Integer num){
        this.numOfReservations = num;
    }

    public TotalReservations() {

    }

    public void increase(){
        numOfReservations++;
    }

    public void decrease(){
        numOfReservations--;
    }
}
