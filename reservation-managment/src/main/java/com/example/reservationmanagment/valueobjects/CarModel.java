package com.example.reservationmanagment.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;
import lombok.Getter;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class CarModel implements ValueObject {
    private final String carModel;
    public CarModel() {
        this.carModel = "";
    }
    public CarModel(String carModel) {
        this.carModel = carModel;
    }
}
