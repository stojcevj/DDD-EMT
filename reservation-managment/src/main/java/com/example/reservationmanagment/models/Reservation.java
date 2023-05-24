package com.example.reservationmanagment.models;

import com.example.reservationmanagment.models.modelID.CarID;
import com.example.reservationmanagment.models.modelID.ReservationID;
import com.example.reservationmanagment.valueobjects.CustomerID;
import com.example.reservationmanagment.valueobjects.FromDateToDate;
import com.example.reservationmanagment.valueobjects.Money;
import com.example.reservationmanagment.valueobjects.RatingID;
import com.example.sharedkernel.domain.models.AbstractEntity;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
public class Reservation extends AbstractEntity<ReservationID> {
    private FromDateToDate reservationTime;
    @AttributeOverride(name="id", column = @Column(name="customer_id", nullable = false))
    private CustomerID customerID;
    @AttributeOverride(name="id", column = @Column(name="rating_id", nullable = false))
    private RatingID ratingID;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Car> reservedCars = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Location reservedLocation;
    public Reservation(){
        super(ReservationID.randomId(ReservationID.class));
    }
    public Reservation(FromDateToDate fromDateToDate, CustomerID customerID, RatingID ratingID){
        super(ReservationID.randomId(ReservationID.class));
        this.reservationTime = fromDateToDate;
        this.customerID = customerID;
        this.ratingID = ratingID;
    }
    public Money total(){
        return new Money(reservedCars.stream().mapToDouble(s -> s.getCarPrice().getPrice()).sum());
    }
    public Car addCar(@NonNull Car car){
        Objects.requireNonNull(car, "car must not be null");
        reservedCars.add(car);
        return car;
    }

    public void removeCar(@NonNull CarID carID){
        Objects.requireNonNull(carID, "carID must not be null");
        reservedCars.removeIf(s -> s.getId().getId().equals(carID.getId()));
    }

    public void addLocation(@NonNull Location location){
        Objects.requireNonNull(location, "locationID) must not be null");
        this.reservedLocation = location;
    }
}
