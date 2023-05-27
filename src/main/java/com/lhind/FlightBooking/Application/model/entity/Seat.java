package com.lhind.FlightBooking.Application.model.entity;

import com.lhind.FlightBooking.Application.model.enums.BookingClass;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "seat")
@Data
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BookingClass bookingClass;
    private int availableSeats;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
