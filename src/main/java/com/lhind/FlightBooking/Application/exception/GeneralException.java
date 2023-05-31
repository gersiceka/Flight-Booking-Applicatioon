package com.lhind.FlightBooking.Application.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralException extends RuntimeException {
    private String message;
}
