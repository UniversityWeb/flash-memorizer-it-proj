package com.uniteam.flashmemorizer.converter;

import com.uniteam.flashmemorizer.dto.SharedDeckDTO;
import com.uniteam.flashmemorizer.entity.SharedDeck;
import org.springframework.stereotype.Component;

@Component
public class SharedDeckConverter extends BaseConverter<SharedDeck, SharedDeckDTO> {

    @Override
    protected Class<SharedDeckDTO> getDtoClass() {
        return SharedDeckDTO.class;
    }

    @Override
    protected Class<SharedDeck> getEntityClass() {
        return SharedDeck.class;
    }

    @Override
    protected void configuration() {

    }
}