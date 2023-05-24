package com.example.sharedkernel.domain.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Phone implements ValueObject {
    private final String phoneNumber;

    public Phone(){
        this.phoneNumber = "";
    }

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static Phone of(@NonNull String phoneNumber){
        return new Phone(phoneNumber);
    }
}
