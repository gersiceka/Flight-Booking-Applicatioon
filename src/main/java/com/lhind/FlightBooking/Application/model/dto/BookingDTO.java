package com.lhind.FlightBooking.Application.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private Long id;
    private String status;
    private boolean approved;
    private String declineReason;
    private LocalDateTime bookingDate;
    private FlightDTO flight;
    private UserDTO user;
}
