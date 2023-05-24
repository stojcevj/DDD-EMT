package com.example.reservationmanagment.service.impl;

import com.example.reservationmanagment.models.Car;
import com.example.reservationmanagment.models.Reservation;
import com.example.reservationmanagment.models.modelID.ReservationID;
import com.example.reservationmanagment.repository.ReservationRepository;
import com.example.reservationmanagment.service.ReservationService;
import com.example.reservationmanagment.service.forms.CarForm;
import com.example.reservationmanagment.service.forms.LocationForm;
import com.example.reservationmanagment.service.forms.ReservationForm;
import com.example.reservationmanagment.valueobjects.Quantity;
import com.example.reservationmanagment.xport.CustomerClient;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerClient customerClient;

    public ReservationServiceImpl(ReservationRepository reservationRepository, CustomerClient customerClient) {
        this.reservationRepository = reservationRepository;
        this.customerClient = customerClient;
    }

    @Override
    public ReservationID placeReservation(ReservationForm reservationForm) throws InvalidAttributesException {
        Objects.requireNonNull(reservationForm, "Reservation must not be null");
        List<CarForm> carForms = reservationForm.getCars();
        Reservation reservation = reservationForm.getReservation();
        reservationRepository.saveAndFlush(reservation);
        reservation = reservationRepository.findById(reservation.getId()).get();
        for(CarForm car : carForms){
            for(int i=0;i<car.getQuantity();i++){
                addCar(reservation.getId(), car.getCar());
            }
        }
        customerClient.increaseCustomerReservations(reservation.getCustomerID().getId());
        return reservation.getId();
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(ReservationID reservationID) {
        return reservationRepository.findById(reservationID);
    }

    @Override
    public void addCar(ReservationID reservationID, Car car) throws InvalidAttributesException {
        Reservation reservation = reservationRepository.findById(reservationID).orElseThrow(InvalidAttributesException::new);
        reservation.addCar(car);
        car.getQuantity().subtract(new Quantity(1));
        reservationRepository.saveAndFlush(reservation);
    }

    @Override
    public void addLocation(ReservationID reservationID, LocationForm locationForm) throws InvalidAttributesException {
        Reservation reservation = reservationRepository.findById(reservationID).orElseThrow(InvalidAttributesException::new);
        reservation.addLocation(locationForm.getLocation());
        reservationRepository.saveAndFlush(reservation);
    }
}
