package com.lhind.FlightBooking.Application.authentication;

import com.lhind.FlightBooking.Application.objects.MessageJson;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private  AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser( @RequestBody RegisterForm registerForm) {
        authenticationService.registerUser(registerForm);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new MessageJson("User is created successfully."));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) throws IOException {
        return ResponseEntity.ok().body(authenticationService.refreshToken(request));
    }
}

