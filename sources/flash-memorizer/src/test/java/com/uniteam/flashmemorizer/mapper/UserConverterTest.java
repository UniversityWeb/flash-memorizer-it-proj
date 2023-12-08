package com.uniteam.flashmemorizer.mapper;

import com.uniteam.flashmemorizer.config.AppConfig;
import com.uniteam.flashmemorizer.dto.UserDTO;
import com.uniteam.flashmemorizer.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = AppConfig.class)
@ContextConfiguration(classes = UserMapper.class)
class UserConverterTest {
    @Autowired
    private UserMapper userConverter;

    @Test
    public void testConvertEntityToDto() {
        // Arrange
        User user = User.builder()
                .id(1L)
                .username("hihihi")
                .pass("hihi1234")
                .email("hihi@gmail.com")
                .fullName("Hi Tran")
                .registration(new Date())
                .lastLogin(new Date())
                .build();

        // Act
        UserDTO userDTO = userConverter.convertEntityToDto(user);

        // Assert
        assertEquals(userDTO.getId(), user.getId());
        assertEquals(userDTO.getUsername(), user.getUsername());
        assertEquals(userDTO.getPass(), user.getPass());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getFullName(), user.getFullName());
        assertEquals(userDTO.getRegistration(), user.getRegistration());
        assertEquals(userDTO.getLastLogin(), user.getLastLogin());
    }

    @Test
    public void testConvertEntityToDtoNullCase() {
        // Arrange
        User user = null;

        // Act
        UserDTO userDTO = userConverter.convertEntityToDto(user);

        // Assert
        assertNull(userDTO);
    }

    @Test
    public void testConvertDtoToEntity() {
        // Arrange
        UserDTO userDTO = UserDTO.builder()
                .id(1L)
                .username("hihihi")
                .pass("hihi124")
                .email("hihi@gmail.com")
                .fullName("Hi Tran")
                .registration(new Date())
                .lastLogin(new Date())
                .build();

        // Act
        User user = userConverter.convertDtoToEntity(userDTO);

        // Assert
        assertEquals(userDTO.getId(), user.getId());
        assertEquals(userDTO.getUsername(), user.getUsername());
        assertEquals(userDTO.getPass(), user.getPass());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getFullName(), user.getFullName());
        assertEquals(userDTO.getRegistration(), user.getRegistration());
        assertEquals(userDTO.getLastLogin(), user.getLastLogin());
    }

    @Test
    public void testConvertDtoToEntityNullCase() {
        // Arrange
        UserDTO userDTO = null;

        // Act
        User user = userConverter.convertDtoToEntity(userDTO);

        // Assert
        assertNull(user);
    }
}