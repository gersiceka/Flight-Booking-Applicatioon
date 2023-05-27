package com.lhind.FlightBooking.Application.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageJson {
    public MessageJson(String s) {

    }
    @JsonProperty("message")
    private String message;
}
