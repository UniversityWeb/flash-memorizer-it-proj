package com.uniteam.flashmemorizer.strategy.reviewcard;

import com.uniteam.flashmemorizer.dto.CardDTO;
import com.uniteam.flashmemorizer.dto.review.MultiChoiceCard;

import java.util.List;

public class MultiChoice implements ReviewStrategy<MultiChoiceCard> {
    @Override
    public List<MultiChoiceCard> generateTest(List<CardDTO> cards) {
        return null;
    }

    @Override
    public String getResult(List<MultiChoiceCard> cardReviews) {
        return null;
    }
}
