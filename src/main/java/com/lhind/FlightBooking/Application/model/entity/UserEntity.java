package com.lhind.FlightBooking.Application.model.entity;

import com.lhind.FlightBooking.Application.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Role role;
    @OneToMany(mappedBy = "userEntity")
    private List<Booking> bookings;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
