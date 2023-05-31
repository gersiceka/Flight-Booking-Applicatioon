package com.lhind.FlightBooking.Application.controller;

import com.lhind.FlightBooking.Application.mapper.BookingMapper;
import com.lhind.FlightBooking.Application.mapper.FlightMapper;
import com.lhind.FlightBooking.Application.mapper.UserMapper;
import com.lhind.FlightBooking.Application.model.dto.BookingDTO;
import com.lhind.FlightBooking.Application.model.dto.FlightDTO;
import com.lhind.FlightBooking.Application.model.dto.UserDTO;
import com.lhind.FlightBooking.Application.model.entity.Flight;
import com.lhind.FlightBooking.Application.services.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/flights")
public class FlightController {
    private FlightService flightService;
    private FlightMapper flightMapper;
    private BookingMapper bookingMapper;
    private UserMapper userMapper;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/createFlight")
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO flightDto) {
       FlightDTO createdFlightDto = flightMapper.toDto(flightService.createFlight(flightDto));
       return ResponseEntity.created(java.net.URI.create("/flights/" + createdFlightDto.getId())).body(createdFlightDto);

    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/updateFlight")
    public ResponseEntity<FlightDTO> updateFlight(@RequestBody FlightDTO flightDto) {

        FlightDTO updatedFlightDto = flightMapper.toDto(flightService.updateFlight(flightDto));
        return ResponseEntity.ok(updatedFlightDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{flightId}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long flightId) {
        flightService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();   //if flight has not booked
    }


    @PreAuthorize("hasAnyRole('TRAVELLER')")
    @GetMapping("/{flightId}/bookings")
    public ResponseEntity<List<BookingDTO>> getAllBookingsByFlight(@PathVariable Long flightId) {
        List<BookingDTO> bookings = flightService.getAllBookingsByFlight(flightId).stream().map(bookingMapper::toDto).toList();
        return ResponseEntity.ok(bookings);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/{flightId}/travelers")
    public ResponseEntity<List<UserDTO>> getAllTravelersByFlight(@PathVariable Long flightId) {
        List<UserDTO> travelers = flightService.getAllTravelersByFlight(flightId).stream().map(userMapper::toDto).toList();
        return ResponseEntity.ok(travelers);
    }

    @PreAuthorize("hasAnyRole('TRAVELLER')")
    @GetMapping("/available")
    public ResponseEntity<List<FlightDTO>> findAvailableFlights(@RequestParam("origin") String origin,
                                                                @RequestParam("destination") String destination,
                                                                @RequestParam("flightDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate flightDate,
                                                                @RequestParam("airlineCode") String airlineCode) {
        List<Flight> availableFlights = flightService.findAvailableFlights(origin, destination, flightDate, airlineCode);
        List<FlightDTO> flightDto = availableFlights.stream().map(flightMapper::toDto).toList();
        return ResponseEntity.ok(flightDto);
    }
}

