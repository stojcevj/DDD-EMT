package com.example.reservationmanagment.service;

import com.example.reservationmanagment.models.Car;
import com.example.reservationmanagment.models.Reservation;
import com.example.reservationmanagment.models.modelID.ReservationID;
import com.example.reservationmanagment.service.forms.CarForm;
import com.example.reservationmanagment.service.forms.LocationForm;
import com.example.reservationmanagment.service.forms.ReservationForm;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    ReservationID placeReservation(ReservationForm reservationForm) throws InvalidAttributesException;
    List<Reservation> findAll();
    Optional<Reservation> findById(ReservationID reservationID);
    void addCar(ReservationID reservationID, Car car) throws InvalidAttributesException;
    void addLocation(ReservationID reservationID, LocationForm locationForm) throws InvalidAttributesException;
}
