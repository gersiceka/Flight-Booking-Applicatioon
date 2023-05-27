package com.lhind.FlightBooking.Application.model.entity;

import com.lhind.FlightBooking.Application.model.enums.AirlineCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="flights")
@Getter
@Setter
public class Flight {
    @Id
    private Long id;

    @Enumerated(value = EnumType.STRING) // save as string in the db
    private AirlineCode airlineCode;
    private String flightNumber;
    private String origin;
    private String destination;

    @NotNull
    private LocalDate flightDate;
    @NotNull
    private LocalTime departureTime;
    private String aircraftType;
    @OneToMany(mappedBy = "flight")
    private List<Booking> bookings;
    @OneToMany(mappedBy = "flight")
    private List<Seat> seats;
    @OneToMany(mappedBy = "flight")
    private List<UserEntity> userEntities;
}
