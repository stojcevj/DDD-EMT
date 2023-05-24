package com.example.reservationmanagment.models.modelID;

import com.example.sharedkernel.domain.models.DomainObjectId;
import lombok.NonNull;

public class ReservationID extends DomainObjectId {
    private ReservationID(){
        super(ReservationID.randomId(ReservationID.class).getId());
    }

    public ReservationID(@NonNull String uuid){
        super(uuid);
    }
}
