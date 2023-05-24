package com.example.reservationmanagment.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;
import lombok.Getter;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class NumberOfSeats implements ValueObject {
    private final Integer numberOfSeats;

    public NumberOfSeats(){
        this.numberOfSeats = 0;
    }

    public NumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
