package com.lhind.FlightBooking.Application.controller;

import com.lhind.FlightBooking.Application.mapper.UserMapper;
import com.lhind.FlightBooking.Application.model.dto.UserDTO;
import com.lhind.FlightBooking.Application.model.entity.UserEntity;
import com.lhind.FlightBooking.Application.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private UserService userService;
    private UserMapper userMapper;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();

        userService.getAllUsers().forEach(u -> users.add(userMapper.toDto(u)));

        return ResponseEntity.ok(users);
    }

    @PreAuthorize(value="hasAnyRole('ADMIN')")
    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        UserDTO user = userService.getUserByEmail(email).map(userMapper::toDto).orElse(null);
        return ResponseEntity.ok(user);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto) {
        UserDTO createdUserDto = userMapper.toDto(userService.createUser(userMapper.toEntity(userDto)));
        return ResponseEntity.created(URI.create("/users/" + createdUserDto.getId())).body(createdUserDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/updateUser")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto) {
        UserDTO updatedUserDto = userMapper.toDto(userService.updateUser(userMapper.toEntity(userDto)));
        return ResponseEntity.ok(updatedUserDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {
        Optional<UserEntity> userOptional = userService.findById(id);
        return userOptional.map(user -> ResponseEntity.ok(userMapper.toDto(user))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
