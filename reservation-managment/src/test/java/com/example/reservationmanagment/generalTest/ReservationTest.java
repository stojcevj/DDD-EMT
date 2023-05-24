package com.example.reservationmanagment.generalTest;

import com.example.reservationmanagment.models.Car;
import com.example.reservationmanagment.models.Location;
import com.example.reservationmanagment.models.Reservation;
import com.example.reservationmanagment.service.ReservationService;
import com.example.reservationmanagment.service.forms.CarForm;
import com.example.reservationmanagment.service.forms.ReservationForm;
import com.example.reservationmanagment.valueobjects.*;
import com.example.reservationmanagment.xport.CustomerClient;
import com.example.sharedkernel.domain.valueobjects.Address;
import com.example.sharedkernel.domain.valueobjects.Phone;
import com.example.sharedkernel.domain.valueobjects.Rate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class ReservationTest {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CustomerClient customerClient;

    private static Customer newCustomer(String name, String phone, String streetName, Integer number){
        Customer customer = new Customer(CustomerID.randomId(CustomerID.class), name, Phone.of(phone), Address.of(streetName, number));
        return customer;
    }
    private static Rating newRating(Integer rate){
        Rating rating = new Rating(new Rate(rate), RatingID.randomId(RatingID.class));
        return rating;
    }
    private static FromDateToDate newFromDateToDate(String from, String to){
        FromDateToDate fromDateToDate = new FromDateToDate(from, to);
        return fromDateToDate;
    }
    private static Car newCar(String model, Integer numOfSeats, Integer quantity, boolean hasAC ,Double price){
        Car car = new Car(new CarModel(model), new NumberOfSeats(numOfSeats), new Quantity(quantity), hasAC ,new Money(price));
        return car;
    }

    private static Location newLocation(String city, String street, Integer number){
        Location location = new Location(new City(city), new Address(street, number));
        return location;
    }
    @Test
    public void testReservation() throws InvalidAttributesException {
        FromDateToDate date = ReservationTest.newFromDateToDate("10-10-2023", "13-10-2023");
        Customer customer = ReservationTest.newCustomer("Jovan", "078702604", "Romen", 11);
        customerClient.createCustomer(customer.getCustomerID().getId(),customer.getName(),customer.getPhoneNumber().getPhoneNumber(),customer.getAddress().getStreetName(),customer.getAddress().getStreetNumber());
        Rating rating = ReservationTest.newRating(5);

        List<CarForm> carForms = new ArrayList<>();
        carForms.add(new CarForm(ReservationTest.newCar("Ford", 5, 7, true, 4000d), 1));
        carForms.add(new CarForm(ReservationTest.newCar("Audi", 3, 5, true, 2000d), 1));

        Reservation reservation = new Reservation(date, customer.getCustomerID(), rating.getRatingId());
        ReservationForm reservationForm = new ReservationForm(reservation, carForms);

        reservationService.placeReservation(reservationForm);
        assertEquals(new Money(6000d).getPrice(), reservationService.findById(reservation.getId()).get().total().getPrice());
    }
}
