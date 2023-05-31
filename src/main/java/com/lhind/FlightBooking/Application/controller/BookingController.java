package com.lhind.FlightBooking.Application.controller;

import com.lhind.FlightBooking.Application.exception.GeneralException;
import com.lhind.FlightBooking.Application.mapper.BookingMapper;
import com.lhind.FlightBooking.Application.model.dto.BookingDTO;
import com.lhind.FlightBooking.Application.model.entity.Pagination;
import com.lhind.FlightBooking.Application.services.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private BookingService bookingService;
    private BookingMapper bookingMapper;


    @PreAuthorize("hasAnyRole('TRAVELLER')")
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


    @PreAuthorize("hasAnyRole('TRAVELLER')")
    @PostMapping("/{bookingId}/cancel")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) {
        boolean isCanceled = bookingService.cancelBooking(bookingId);
        if (isCanceled) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/{bookingId}/approve")
    public ResponseEntity<Void> approveBooking(@PathVariable Long bookingId) {
        boolean isApproved = bookingService.approveBooking(bookingId);
        if (isApproved) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
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
    //Can view all bookings of a specific traveller
    @PreAuthorize("hasAnyRole('TRAVELLER')")
    @GetMapping("/getBookingsForUser/{id}")
    public ResponseEntity<List<BookingDTO>> getBookingsForUser(@PathVariable(value = "id") Long id,
                                                               @RequestBody(required = false) Pagination pagination){
        try {
            List<BookingDTO> bookings = bookingService.getUserBookings(id, pagination);
            return ResponseEntity.ok(bookings);
        }catch (GeneralException e){
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
            return ResponseEntity.status(BAD_REQUEST).body(null);
        }
    }
}

