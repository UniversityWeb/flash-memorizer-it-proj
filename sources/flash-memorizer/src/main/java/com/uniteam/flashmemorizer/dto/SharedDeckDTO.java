package com.uniteam.flashmemorizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SharedDeckDTO {
    private Long id;
    private UserDTO recipient = new UserDTO();
    private DeckDTO deck = new DeckDTO();
    private Date creation = new Date();
}
