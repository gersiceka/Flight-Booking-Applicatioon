package com.lhind.FlightBooking.Application.testing;
/*
import com.lhind.FlightBooking.Application.model.dto.FlightDTO;
import com.lhind.FlightBooking.Application.model.entity.Flight;
import com.lhind.FlightBooking.Application.repository.FlightRepository;
import com.lhind.FlightBooking.Application.services.FlightService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalTime;

@RunWith(MockitoJUnitRunner.class)
public class FlightServiceTest {

    @InjectMocks
    private FlightService flightService;

    @Mock
    private FlightRepository flightRepository;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createFlight_ValidRequest_FlightCreated() {

        FlightDTO flightDto = new FlightDTO();
        flightDto.setAirlineCode("LH");
        flightDto.setFlightNumber("LH100");
        flightDto.setOrigin("TIA");
        flightDto.setDestination("JFK");
        flightDto.setFlightDate(LocalDate.now());
        flightDto.setDepartureTime(LocalTime.now());

        Mockito.when(flightRepository.save(Mockito.any(Flight.class))).thenAnswer(invocation -> {
            Flight flight = invocation.getArgument(0);
            flight.setId(1L);
            return flight;
        });

        Flight createdFlight = flightService.createFlight(flightDto);

        Assert.assertNotNull(createdFlight);
        Assert.assertEquals(flightDto.getAirlineCode(), createdFlight.getAirlineCode());
        Assert.assertEquals(flightDto.getFlightNumber(), createdFlight.getFlightNumber());
        Assert.assertEquals(flightDto.getOrigin(), createdFlight.getOrigin());
        Assert.assertEquals(flightDto.getDestination(), createdFlight.getDestination());
        Assert.assertEquals(flightDto.getFlightDate(), createdFlight.getFlightDate());
        Assert.assertEquals(flightDto.getDepartureTime(), createdFlight.getDepartureTime());
    }
}*/
