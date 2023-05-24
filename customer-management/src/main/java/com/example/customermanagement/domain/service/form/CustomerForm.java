package com.example.customermanagement.domain.service.form;

import com.example.customermanagement.domain.model.valueobjects.TotalReservations;
import com.example.sharedkernel.domain.valueobjects.Address;
import com.example.sharedkernel.domain.valueobjects.Phone;
import lombok.Data;
import lombok.NonNull;

@Data
public class CustomerForm {
    @NonNull
    private String name;
    @NonNull
    private Phone phoneNumber;
    @NonNull
    private Address address;
    @NonNull
    TotalReservations totalReservations;
}
