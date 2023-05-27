package com.lhind.FlightBooking.Application.testing;
/*
import com.lhind.FlightBooking.Application.model.dto.BookingDTO;
import com.lhind.FlightBooking.Application.model.entity.Booking;
import com.lhind.FlightBooking.Application.model.entity.Flight;
import com.lhind.FlightBooking.Application.repository.BookingRepository;
import com.lhind.FlightBooking.Application.services.BookingService;
import com.lhind.FlightBooking.Application.services.FlightService;
import com.lhind.FlightBooking.Application.services.UserService;
import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private UserService userService;

    @Mock
    private FlightService flightService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createBooking_ValidRequest_BookingCreated() {

        User user = new User();
        user.setId(1L);

        Flight flight1 = new Flight();
        flight1.setId(1L);

        Flight flight2 = new Flight();
        flight2.setId(2L);

        BookingDTO bookingDto = new BookingDTO();
        bookingDto.setUserId.(user.getId());
        bookingDto.setFlightIds(Arrays.asList(flight1.getId(), flight2.getId()));

        Mockito.when(userService.getUser(user.getId())).thenReturn(user);
        Mockito.when(flightService.getFlightsByIds(bookingDto.getFlightIds())).thenReturn(Arrays.asList(flight1, flight2));

        Booking createdBooking = bookingService.createBooking(bookingDto);

        Assert.assertNotNull(createdBooking);
        Assert.assertEquals(user, createdBooking.getUser());
        Assert.assertEquals(Arrays.asList(flight1, flight2), createdBooking.getFlights());
    }
}

*/