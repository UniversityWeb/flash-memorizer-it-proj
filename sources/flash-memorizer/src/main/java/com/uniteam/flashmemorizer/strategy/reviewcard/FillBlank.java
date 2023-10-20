package com.uniteam.flashmemorizer.strategy.reviewcard;

import com.uniteam.flashmemorizer.dto.CardDTO;
import com.uniteam.flashmemorizer.dto.review.FillBlankCard;

import java.util.List;

public class FillBlank implements ReviewStrategy<FillBlankCard> {
    @Override
    public List<FillBlankCard> generateTest(List<CardDTO> cards) {
        return null;
    }

    @Override
    public String getResult(List<FillBlankCard> cardReviews) {
        return null;
    }
}
