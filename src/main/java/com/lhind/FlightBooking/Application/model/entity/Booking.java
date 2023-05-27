package com.lhind.FlightBooking.Application.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    private Long id;
    @NotNull
    private String status;
    private boolean approved;
    private String declineReason;
    private boolean cancel;
    @NotNull
    private LocalDateTime bookingDate;
    @ManyToOne
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
