package com.lhind.FlightBooking.Application.testing;
/*
import com.lhind.FlightBooking.Application.model.dto.UserDTO;
import com.lhind.FlightBooking.Application.model.enums.Role;
import com.lhind.FlightBooking.Application.repository.UserRepository;
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

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createUser_ValidRequest_UserCreated() {
        // Përgatit
        UserDTO userDto = new UserDTO();
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("johndoe@example.com");
        userDto.setRole(Role.TRAVELLER);

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenAnswer(invocation -> {
            User user = invocation.getArgument(0);
            user.setId(1L);
            return user;
        });


        User createdUser = userService.createUser(userDto);

        Assert.assertNotNull(createdUser);
        Assert.assertEquals(userDto.getFirstName(), createdUser.getFirstName());
        Assert.assertEquals(userDto.getLastName(), createdUser.getLastName());
        Assert.assertEquals(userDto.getEmail(), createdUser.getEmail());
        Assert.assertEquals(userDto.getRole(), createdUser.getRole());
    }
}

*/