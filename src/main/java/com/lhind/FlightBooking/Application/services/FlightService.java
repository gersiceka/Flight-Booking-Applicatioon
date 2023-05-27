package com.lhind.FlightBooking.Application.services;

import com.lhind.FlightBooking.Application.mapper.FlightMapper;
import com.lhind.FlightBooking.Application.model.dto.FlightDTO;
import com.lhind.FlightBooking.Application.model.entity.Booking;
import com.lhind.FlightBooking.Application.model.entity.Flight;
import com.lhind.FlightBooking.Application.model.entity.UserEntity;
import com.lhind.FlightBooking.Application.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightService  {

    private FlightRepository flightRepository;
    private FlightMapper flightMapper;


    public Flight createFlight(FlightDTO flightDto) {
        return flightRepository.save(flightMapper.toEntity(flightDto));
    }

    public Flight updateFlight(FlightDTO flightDto) {
        return flightRepository.save(flightMapper.toEntity(flightDto));
        }


    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }


    public List<Booking> getAllBookingsByFlight(Long flightId) {
        Optional<Flight> flight = flightRepository.findById(flightId);

        if (flight.isPresent()) {
            return flight.get().getBookings();
        }

        return new ArrayList<>();
    }


    public List<UserEntity> getAllTravelersByFlight(Long flightId) {
        Optional<Flight> flight = flightRepository.findById(flightId);

        if (flight.isPresent()) {
            return flight.get().getUserEntities();
        }

        return new ArrayList<>();
    }
    public List<Flight> findAvailableFlights(String origin, String destination, LocalDate flightDate, String airlineCode) {
        return flightRepository.findAvailableFlights(origin, destination, flightDate, airlineCode);
    }

}

