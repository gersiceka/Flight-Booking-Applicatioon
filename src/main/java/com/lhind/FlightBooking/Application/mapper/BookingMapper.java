package com.lhind.FlightBooking.Application.mapper;

import com.lhind.FlightBooking.Application.model.dto.BookingDTO;
import com.lhind.FlightBooking.Application.model.entity.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingDTO toDto (Booking booking) {
        BookingDTO dto=new BookingDTO();

        dto.setId(booking.getId());
        dto.setStatus(booking.getStatus());
        dto.setApproved(booking.isApproved());
        dto.setDeclineReason(booking.getDeclineReason());
        dto.setBookingDate(booking.getBookingDate());

        dto.setStatus(booking.getStatus());
        return dto;
    }

    public Booking toEntity(BookingDTO bookingDto) {

        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setStatus(bookingDto.getStatus());
        return booking;
    }

}


