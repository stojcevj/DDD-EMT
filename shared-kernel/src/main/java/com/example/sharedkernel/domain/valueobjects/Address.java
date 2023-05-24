package com.example.sharedkernel.domain.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address implements ValueObject {
    private final String streetName;
    private final Integer streetNumber;

    public Address(){
        this.streetName = "";
        this.streetNumber = 0;
    }

    public Address(String streetName, Integer streetNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public static Address of(@NonNull String streetName, @NonNull Integer streetNumber){
        return new Address(streetName, streetNumber);
    }
}
