package com.example.reservationmanagment.repository;

import com.example.reservationmanagment.models.Reservation;
import com.example.reservationmanagment.models.modelID.ReservationID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationID> {
}
