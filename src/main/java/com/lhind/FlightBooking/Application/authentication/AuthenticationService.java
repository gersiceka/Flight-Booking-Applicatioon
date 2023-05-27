package com.lhind.FlightBooking.Application.authentication;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public void registerUser(RegisterForm registerForm) {
    }

    public Object authenticate(AuthenticationRequest request) {
        return null;
    }

    public Object refreshToken(HttpServletRequest request) {
        return null;
    }

}


