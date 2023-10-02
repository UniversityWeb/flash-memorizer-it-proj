package com.uniteam.flashmemorizer.service.impl;

import com.uniteam.flashmemorizer.converter.UserCardConverter;
import com.uniteam.flashmemorizer.dto.UserCardDTO;
import com.uniteam.flashmemorizer.entity.UserCard;
import com.uniteam.flashmemorizer.entity.key.UserCardId;
import com.uniteam.flashmemorizer.repository.UserCardRepository;
import com.uniteam.flashmemorizer.service.UserCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCardServiceImpl implements UserCardService {

    @Autowired
    private UserCardRepository userCardRepo;

    @Autowired
    private UserCardConverter userCardConverter;

    @Override
    public UserCardDTO add(UserCardDTO userCardDTO) {
        UserCard userCard = userCardConverter.convertDtoToEntity(userCardDTO);
        try {
            UserCard added = userCardRepo.save(userCard);
            return userCardConverter.convertEntityToDto(added);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserCardDTO update(UserCardDTO userCardDTO) {
        Optional<UserCard> optUser = userCardRepo.findById(
                new UserCardId(
                        userCardDTO.getCard().getId(),
                        userCardDTO.getUser().getId()
                ));
        if (optUser.isEmpty()) return null;
        try {
            UserCard updated = userCardRepo.save(optUser.get());
            return userCardConverter.convertEntityToDto(updated);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserCardDTO getById(UserCardId Id) {
        UserCard userCard = userCardRepo.findById(Id).get();
        return userCardConverter.convertEntityToDto(userCard);
    }
}
