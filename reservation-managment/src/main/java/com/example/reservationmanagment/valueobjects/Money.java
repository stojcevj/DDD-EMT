package com.example.reservationmanagment.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Money implements ValueObject {
    private final Double price;

    public Money(){
        this.price = 0d;
    }

    public Money(Double amount){
        this.price = amount;
    }

    public Money add(Money m){
        return new Money(this.price + m.price);
    }

    public Money subtract(Money m){
        return new Money(this.price - m.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return price.equals(money.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
