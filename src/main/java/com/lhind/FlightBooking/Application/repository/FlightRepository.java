package com.lhind.FlightBooking.Application.repository;

import com.lhind.FlightBooking.Application.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("select F from Flight F where F.origin=?1 or F.destination=?1 or F.flightDate=?1 or F.airlineCode=?1" )
    List<Flight> findAvailableFlights(String origin, String destination, LocalDate flightDate, String airlineCode);
}


