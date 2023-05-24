package com.example.reservationmanagment.valueobjects;

import com.example.sharedkernel.domain.models.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class FromDateToDate implements ValueObject {
    private final String dateFrom;
    private final String dateTo;

    public FromDateToDate(){
        dateFrom = "";
        dateTo = "";
    }

    public FromDateToDate(String dateFrom, String dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
