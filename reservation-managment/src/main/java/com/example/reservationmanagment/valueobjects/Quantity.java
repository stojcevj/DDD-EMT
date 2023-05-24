package com.example.reservationmanagment.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;
import lombok.Getter;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Quantity implements ValueObject {
    private final Integer quantity;

    public Quantity(){
        this.quantity = 0;
    }

    public Quantity(Integer qty){
        this.quantity = qty;
    }
    public Quantity add(Quantity quantity){
        return new Quantity(this.quantity + quantity.quantity);
    }
    public Quantity subtract(Quantity quantity){
        return new Quantity(this.quantity - quantity.quantity);
    }
}
