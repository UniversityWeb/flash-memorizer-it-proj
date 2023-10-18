package com.uniteam.flashmemorizer.config;

import com.uniteam.flashmemorizer.entity.*;
import com.uniteam.flashmemorizer.customenum.ERating;
import com.uniteam.flashmemorizer.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CardRepository cardRepo;
    private final DeckRepository deckRepo;
    private final UserRepository userRepo;
    private final UserCardRepository userCardRepo;
    private final SharedDeckRepository sharedDeckRepo;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        clearAllData();
        initData();
    }

    private void clearAllData() {
        sharedDeckRepo.deleteAll();
        userCardRepo.deleteAll();
        cardRepo.deleteAll();
        deckRepo.deleteAll();
        userRepo.deleteAll();
    }

    private void initData() {
        List<User> users = initUser();
        List<Deck> decks = initDeck( users.get(0) );
        List<Card> cards = initCard( decks.get(0) );
        initUserCard( cards.get(0), users.get(0) );
        initSharedDeck( users.get(1), decks.get(0) );
    }

    private List<User> initUser() {
        List<User> users = List.of(
                User.builder()
                        .username("username1")
                        .pass( encoder.encode("pass2") )
                        .email("user1@gmail.com")
                        .fullName("User One")
                        .registration(new Date(2023, 1, 1, 12, 12, 12))
                        .lastLogin(new Date(2023, 1, 2, 4, 12, 12))
                        .role("ADMIN")
                        .build(),
                User.builder()
                        .username("username2")
                        .pass( encoder.encode("pass2") )
                        .email("user2@gamil.com")
                        .fullName("User Two")
                        .registration(new Date(2023, 4, 4, 5, 5, 5))
                        .lastLogin(new Date(2023, 3, 1, 4, 5, 6))
                        .role("USERS")
                        .build()
        );
        return userRepo.saveAll(users);
    }

    private List<Deck> initDeck(User user) {
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
        return deckRepo.saveAll(decks);
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
        return cardRepo.saveAll(cards);
    }

    private List<UserCard> initUserCard(Card card, User user) {
        List<UserCard> userCards = List.of(
                UserCard.builder()
                        .cardId(card.getId())
                        .userId(user.getId())
                        .lastReview(new Date(2023, 1, 1, 12, 1, 2))
                        .reviewCount(4L)
                        .interval(12L)
                        .rating(ERating.HIGH)
                        .card(card)
                        .user(user)
                        .build()
        );
        return userCardRepo.saveAll(userCards);
    }

    private List<SharedDeck> initSharedDeck(User recipient, Deck deck) {
        List<SharedDeck> sharedDecks = List.of(
                SharedDeck.builder()
                        .recipientId(recipient.getId())
                        .deckId(deck.getId())
                        .recipient(recipient)
                        .deck(deck)
                        .creation(new Date(2023, 10, 10, 1, 3, 4))
                        .build()
        );
        return sharedDeckRepo.saveAll(sharedDecks);
    }
}