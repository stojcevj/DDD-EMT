package com.example.reservationmanagment.models;

import com.example.reservationmanagment.models.modelID.LocationID;
import com.example.sharedkernel.domain.valueobjects.Address;
import com.example.reservationmanagment.valueobjects.City;
import com.example.sharedkernel.domain.models.AbstractEntity;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Entity;

@Entity
@Getter
public class Location extends AbstractEntity<LocationID> {
    private City city;
    private Address address;

    private Location(){
        super(LocationID.randomId(LocationID.class));
    }

    public Location(@NonNull City city, @NonNull Address address){
        super(LocationID.randomId(LocationID.class));
        this.city = city;
        this.address = address;
    }

    public static Location build(@NonNull City city, @NonNull Address address){
        Location location = new Location();
        location.city = city;
        location.address = address;
        return location;
    }
}
