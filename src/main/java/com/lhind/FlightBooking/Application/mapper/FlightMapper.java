package com.lhind.FlightBooking.Application.mapper;

import com.lhind.FlightBooking.Application.model.dto.FlightDTO;
import com.lhind.FlightBooking.Application.model.entity.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    public FlightDTO toDto(Flight flight) {
        FlightDTO dto = new FlightDTO();

        dto.setAirlineCode(flight.getAirlineCode());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setOrigin(flight.getOrigin());
        dto.setDestination(flight.getDestination());
        dto.setFlightDate(flight.getFlightDate());
        dto.setDepartureTime(flight.getDepartureTime());
        dto.setAircraftType(flight.getAircraftType());
        dto.setSeats(flight.getSeats());

        return dto;
    }

    public Flight toEntity(FlightDTO dto) {
        Flight flight = new Flight();

        flight.setAirlineCode(dto.getAirlineCode());
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setOrigin(dto.getOrigin());
        flight.setDestination(dto.getDestination());
        flight.setFlightDate(dto.getFlightDate());
        flight.setDepartureTime(dto.getDepartureTime());
        flight.setAircraftType(dto.getAircraftType());
        flight.setSeats(dto.getSeats());

        return flight;
    }
}
