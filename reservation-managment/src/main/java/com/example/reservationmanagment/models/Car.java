package com.example.reservationmanagment.models;

import com.example.reservationmanagment.models.modelID.CarID;
import com.example.reservationmanagment.valueobjects.CarModel;
import com.example.reservationmanagment.valueobjects.Money;
import com.example.reservationmanagment.valueobjects.NumberOfSeats;
import com.example.reservationmanagment.valueobjects.Quantity;
import com.example.sharedkernel.domain.models.AbstractEntity;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Entity;

@Entity
@Getter
public class Car extends AbstractEntity<CarID> {
    private CarModel carModel;
    private NumberOfSeats numOfSeats;
    private Quantity quantity;
    private Boolean hasAC;
    private Money carPrice;

    private Car(){
        super(CarID.randomId(CarID.class));
    }

    public Car(@NonNull CarModel carModel,
               @NonNull NumberOfSeats numberOfSeats,
               @NonNull Quantity quantity,
               @NonNull Boolean hasAC,
               @NonNull Money carPrice){
        super(CarID.randomId(CarID.class));
        this.carModel = carModel;
        this.numOfSeats = numberOfSeats;
        this.quantity = quantity;
        this.hasAC = hasAC;
        this.carPrice = carPrice;
    }
    public static Car build(CarModel carModel,
                            NumberOfSeats numberOfSeats,
                            Quantity quantity,
                            Boolean hasAC,
                            Money carPrice){
        Car c = new Car();
        c.carModel = carModel;
        c.numOfSeats = numberOfSeats;
        c.quantity = quantity;
        c.hasAC = hasAC;
        c.carPrice = carPrice;
        return c;
    }
}
