package com.lhind.FlightBooking.Application.controller;

import com.lhind.FlightBooking.Application.mapper.BookingMapper;
import com.lhind.FlightBooking.Application.model.dto.BookingDTO;
import com.lhind.FlightBooking.Application.services.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private BookingService bookingService;
    private BookingMapper bookingMapper;


    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDto) {
        BookingDTO createdBookingDto = bookingMapper.toDto(bookingService.createBooking(bookingMapper.toEntity(bookingDto)));
        return ResponseEntity.created(URI.create("/bookings/" + createdBookingDto.getId())).body(createdBookingDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<BookingDTO>> getUserBookings(
            @PathVariable Long userId,

            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int pageSize
    ) {
        return getUserBookings(userId, page, pageSize);

    }


    @PostMapping("/{bookingId}/cancel")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) {
        boolean isCanceled = bookingService.cancelBooking(bookingId);
        if (isCanceled) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{bookingId}/approve")
    public ResponseEntity<Void> approveBooking(@PathVariable Long bookingId) {
        boolean isApproved = bookingService.approveBooking(bookingId);
        if (isApproved) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{bookingId}/decline")
    public ResponseEntity<Void> declineBooking(
            @PathVariable Long bookingId,
            @RequestParam String declineReason
    ) {
        boolean isDeclined = bookingService.declineBooking(bookingId, declineReason);
        if (isDeclined) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

