package com.uniteam.flashmemorizer.service;


import com.uniteam.flashmemorizer.dto.SharedDeckDTO;

import java.util.List;

public interface SharedDeckService {
    SharedDeckDTO add(SharedDeckDTO sharedDeckDTO);
    boolean delete(Long id);
    SharedDeckDTO update(SharedDeckDTO sharedDeckDTO);
    List<SharedDeckDTO> getBySharerId(Long senderId);
}
