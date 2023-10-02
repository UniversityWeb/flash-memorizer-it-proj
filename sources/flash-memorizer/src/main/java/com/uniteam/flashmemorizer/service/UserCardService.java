package com.uniteam.flashmemorizer.service;

import com.uniteam.flashmemorizer.dto.UserCardDTO;
import com.uniteam.flashmemorizer.entity.key.UserCardId;

public interface UserCardService {
    UserCardDTO add(UserCardDTO userDTO);
    UserCardDTO update(UserCardDTO userDTO);
    UserCardDTO getById(UserCardId Id);
}
