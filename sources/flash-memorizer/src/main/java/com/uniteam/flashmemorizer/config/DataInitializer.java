package com.uniteam.flashmemorizer.config;

import com.uniteam.flashmemorizer.controller.CardController;
import com.uniteam.flashmemorizer.entity.Card;
import com.uniteam.flashmemorizer.entity.Deck;
import com.uniteam.flashmemorizer.entity.User;
import com.uniteam.flashmemorizer.repository.CardRepository;
import com.uniteam.flashmemorizer.repository.DeckRepository;
import com.uniteam.flashmemorizer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final Logger log = LogManager.getLogger(CardController.class);

    private final CardRepository cardRepo;
    private final DeckRepository deckRepo;
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        clearAllData();
        initData();
    }

    private void clearAllData() {
        cardRepo.deleteAll();
        deckRepo.deleteAll();
    }

    private void initData() {
        List<User> users = initUser();
        List<Deck> savedDecks = initDeck( users.get(0).getUsername() );
        List<Card> cards = initCard( savedDecks.get(0) );
    }

    private List<User> initUser() {
        final String DEFAULT_HASHED_PASS = encoder.encode("123456");

        List<User> users = List.of(
                User.builder()
                        .username("username1")
                        .pass(DEFAULT_HASHED_PASS)
                        .email("user1@gmail.com")
                        .fullName("User One")
                        .registration(new Date(2023, 1, 1, 12, 12, 12))
                        .lastLogin(new Date(2023, 1, 2, 4, 12, 12))
                        .role("ADMIN")
                        .isEnabled(true)
                        .build(),
                User.builder()
                        .username("username2")
                        .pass(DEFAULT_HASHED_PASS)
                        .email("user2@gamil.com")
                        .fullName("User Two")
                        .registration(new Date(2023, 4, 4, 5, 5, 5))
                        .lastLogin(new Date(2023, 3, 1, 4, 5, 6))
                        .role("USERS")
                        .isEnabled(true)
                        .build()
        );
        try {
            userRepo.saveAll(users);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return users;
    }

    private List<Deck> initDeck(String username) {
        User user = userRepo.findByUsername(username);

        List<Deck> decks = List.of(
                Deck.builder()
                        .name("Deck 1")
                        .desc("Deck Desc 1")
                        .creation(new Date(2023, 1, 1, 12, 0 ,0))
                        .modified(new Date(2023, 3, 1, 12, 0, 0))
                        .user(user)
                        .build(),
                Deck.builder()
                        .name("Deck 2")
                        .desc("Deck Desc 2")
                        .creation(new Date(2023, 1, 1, 12, 0 ,0))
                        .modified(new Date(2023, 3, 1, 12, 0, 0))
                        .user(user)
                        .build()
        );
        List<Deck> savedDecks = new ArrayList<>();
        try {
            savedDecks = deckRepo.saveAll(decks);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return savedDecks;
    }

    private List<Card> initCard(Deck deck) {
        List<Card> cards = List.of(
                Card.builder()
                        .term("Term <b>1</b>")
                        .desc("Description 1; this is a long description to test for our flashcards project.")
                        .deck(deck)
                        .build(),
                Card.builder()
                        .term("Term 2")
                        .desc("Description 2; this i<b>s a long description to test for our flashcard</b>s project.")
                        .deck(deck)
                        .build(),
                Card.builder()
                        .term("<i>Term 3</i>")
                        .desc("Description 3; this is a long description to test for our flashcards project.")
                        .deck(deck)
                        .build(),
                Card.builder()
                        .term("<b>Term 4</b>")
                        .desc("Descrip<em>tion 4;  this is a</em> short description.")
                        .deck(deck)
                        .build(),
                Card.builder()
                        .term("Term 5")
                        .desc("D<i>escription 5; a short description</i>.")
                        .deck(deck)
                        .build(),
                Card.builder()
                        .term("Term 6")
                        .desc("Description 6;")
                        .deck(deck)
                        .build()
        );
        List<Card> savedCards = new ArrayList<>();
        try {
            savedCards = cardRepo.saveAll(cards);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return savedCards;
    }
}
