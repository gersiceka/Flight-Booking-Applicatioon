package com.lhind.FlightBooking.Application.services;

import com.lhind.FlightBooking.Application.model.entity.Booking;
import com.lhind.FlightBooking.Application.model.entity.UserEntity;
import com.lhind.FlightBooking.Application.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
         return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(UserEntity userEntity, String page, String pageSize) {
        int pageNumber = Integer.parseInt(page);
        int size = Integer.parseInt(pageSize);
        Pageable pageable = PageRequest.of(pageNumber - 1, size);

        return bookingRepository.getBookingByUserEntity(userEntity, pageable);
    }

    public boolean cancelBooking(Long bookingId) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setCancel(true);
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }


    public boolean approveBooking(Long bookingId) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setApproved(true);
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }

    public boolean declineBooking(Long bookingId, String declineReason) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setCancel(true);
            booking.setDeclineReason(declineReason);
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }

}

