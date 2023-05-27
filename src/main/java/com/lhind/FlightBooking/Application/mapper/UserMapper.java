package com.lhind.FlightBooking.Application.mapper;

import com.lhind.FlightBooking.Application.model.dto.UserDTO;
import com.lhind.FlightBooking.Application.model.entity.UserEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserMapper {

    public UserDTO toDto(UserEntity userEntity) {
        UserDTO dto = new UserDTO();

        dto.setFirstName(userEntity.getFirstName());
        dto.setMiddleName(userEntity.getMiddleName());
        dto.setLastName(userEntity.getLastName());
        dto.setEmail(userEntity.getEmail());
        dto.setPhoneNumber(userEntity.getPhoneNumber());
        dto.setAddress(userEntity.getAddress());
        dto.setRole(userEntity.getRole());

        return dto;
    }

    public UserEntity toEntity(UserDTO dto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(dto.getFirstName());
        userEntity.setMiddleName(dto.getMiddleName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setEmail(dto.getEmail());
        userEntity.setPhoneNumber(dto.getPhoneNumber());
        userEntity.setAddress(dto.getAddress());
        userEntity.setRole(dto.getRole());

        return userEntity;
    }
}


