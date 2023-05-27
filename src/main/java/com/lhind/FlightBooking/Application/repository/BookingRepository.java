package com.lhind.FlightBooking.Application.repository;

import com.lhind.FlightBooking.Application.model.entity.Booking;
import com.lhind.FlightBooking.Application.model.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> getBookingByUserEntity(UserEntity userEntity, Pageable pageable);
}
