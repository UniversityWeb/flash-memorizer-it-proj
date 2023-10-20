package com.uniteam.flashmemorizer.strategy.reviewcard;

import com.uniteam.flashmemorizer.dto.CardDTO;
import com.uniteam.flashmemorizer.dto.review.MatchingCard;

import java.util.List;

public class Matching implements ReviewStrategy<MatchingCard> {

    @Override
    public List<MatchingCard> generateTest(List<CardDTO> cards) {
        return null;
    }

    @Override
    public String getResult(List<MatchingCard> cardReviews) {
        return null;
    }
}
