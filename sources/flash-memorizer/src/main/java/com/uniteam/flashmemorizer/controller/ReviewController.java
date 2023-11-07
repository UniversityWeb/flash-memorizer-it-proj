package com.uniteam.flashmemorizer.controller;

import com.uniteam.flashmemorizer.dto.*;
import com.uniteam.flashmemorizer.customenum.EReview;
import com.uniteam.flashmemorizer.exception.DeckNotFoundException;
import com.uniteam.flashmemorizer.form.CardReviewForm;
import com.uniteam.flashmemorizer.form.FillBlankForm;
import com.uniteam.flashmemorizer.form.MultiChoiceForm;
import com.uniteam.flashmemorizer.service.CardReviewService;
import com.uniteam.flashmemorizer.service.CardService;
import com.uniteam.flashmemorizer.service.DeckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {
    private final Logger log = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    private CardService cardService;
    @Autowired
    private DeckService deckService;
    @Autowired
    private CardReviewService reviewService;

    @GetMapping("/get-review")
    public String review(@RequestParam EReview reviewType, @RequestParam Long deckId, Model m
    ) throws DeckNotFoundException {
        DeckDTO deck = deckService.getById(deckId);
        List<CardDTO> cards = cardService.getByDeckId(deckId);
        var cardReviews = reviewService.generateTest(reviewType, cards);

        CardReviewForm cardReviewForm = CardReviewForm.builder()
                .deckId(deckId)
                .deckName(deck.getName())
                .reviewType(reviewType)
                .isSubmitted(false)
                .cardReviews(cardReviews)
                .build();

        m.addAttribute("cardReviewForm", cardReviewForm);

        return reviewType.getReviewFile();
    }

    @PostMapping("/submit-fill-blank")
    public String submitFillBlank(@ModelAttribute("cardReviewForm") FillBlankForm cardReviewForm, Model m) {
        return getResultForm(cardReviewForm, m, "fill-blank-result");
    }

    @PostMapping("/submit-multi-choice")
    public String submitMultiChoice(@ModelAttribute("cardReviewForm") MultiChoiceForm cardReviewForm, Model m) {
        return getResultForm(cardReviewForm, m, "multi-choice-result");
    }

    private String getResultForm(CardReviewForm cardReviewForm, Model m, String formName) {
        if (cardReviewForm.isSubmitted()) {
            return "review-result-error";
        }
        cardReviewForm.setSubmitted(true);
        String result = reviewService.getResult(cardReviewForm.getReviewType(), cardReviewForm.getCardReviews());
        cardReviewForm.setResult(result);

        m.addAttribute("cardReviewForm", cardReviewForm);

        return formName;
    }
}