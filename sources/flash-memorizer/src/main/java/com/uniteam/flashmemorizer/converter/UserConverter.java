package com.uniteam.flashmemorizer.converter;

import com.uniteam.flashmemorizer.dto.UserDTO;
import com.uniteam.flashmemorizer.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends BaseConverter<User, UserDTO> {

    @Override
    protected Class<UserDTO> getDtoClass() {
        return UserDTO.class;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected void configuration() {

    }
}
