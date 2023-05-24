package com.example.reservationmanagment.service.forms;

import com.example.reservationmanagment.models.Car;
import com.example.reservationmanagment.models.Reservation;
import com.example.reservationmanagment.valueobjects.Customer;
import com.example.reservationmanagment.valueobjects.Rating;
import lombok.Data;

import java.util.List;

@Data
public class ReservationForm {
    private Reservation reservation;
    private List<CarForm> cars;

    public ReservationForm(Reservation reservation, List<CarForm> cars) {
        this.reservation = reservation;
        this.cars = cars;
    }
}
