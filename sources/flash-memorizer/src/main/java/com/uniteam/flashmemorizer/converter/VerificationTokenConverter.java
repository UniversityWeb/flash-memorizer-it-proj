package com.uniteam.flashmemorizer.converter;

import com.uniteam.flashmemorizer.dto.VerificationTokenDTO;
import com.uniteam.flashmemorizer.entity.VerificationToken;
import org.springframework.stereotype.Component;

@Component
public class VerificationTokenConverter extends BaseConverter<VerificationToken, VerificationTokenDTO> {
    @Override
    protected Class<VerificationTokenDTO> getDtoClass() {
        return VerificationTokenDTO.class;
    }

    @Override
    protected Class<VerificationToken> getEntityClass() {
        return VerificationToken.class;
    }

    @Override
    protected void configuration() {

    }
}
