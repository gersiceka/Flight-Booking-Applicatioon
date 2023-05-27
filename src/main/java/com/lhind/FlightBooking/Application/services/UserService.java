package com.lhind.FlightBooking.Application.services;

import com.lhind.FlightBooking.Application.model.entity.UserEntity;
import com.lhind.FlightBooking.Application.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public UserEntity updateUser(UserEntity userEntity) {
        UserEntity p = userRepository.findById(userEntity.getId()).orElse(null);
        return userRepository.save(userEntity);
    }

}



