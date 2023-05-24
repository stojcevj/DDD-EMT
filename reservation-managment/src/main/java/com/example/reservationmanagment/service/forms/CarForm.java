package com.example.reservationmanagment.service.forms;

import com.example.reservationmanagment.models.Car;
import lombok.Data;

@Data
public class CarForm {
    private Car car;
    private int quantity = 1;

    public CarForm(Car car, int quantity) {
        this.car = car;
        this.quantity = quantity;
    }
}
