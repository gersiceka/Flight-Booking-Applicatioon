package com.lhind.FlightBooking.Application.model.dto;

import com.lhind.FlightBooking.Application.model.entity.Seat;
import com.lhind.FlightBooking.Application.model.enums.AirlineCode;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
@Data
public class FlightDTO {

    private Long id;
    private AirlineCode airlineCode;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDate flightDate;
    private LocalTime departureTime;
    private String aircraftType;
    private List<Seat> seats;
}
