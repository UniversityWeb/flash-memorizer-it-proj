package com.uniteam.flashmemorizer.dto;

import com.uniteam.flashmemorizer.customenum.ERating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCardDTO {
    private Date lastReview = new Date();
    private Long reviewCount;
    private Long interval;
    private ERating rating = ERating.AVERAGE;
    private CardDTO card = new CardDTO();
    private UserDTO user = new UserDTO();
}
