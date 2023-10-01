package com.uniteam.flashmemorizer.entity;

import com.uniteam.flashmemorizer.entity.key.SharedDeckId;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@IdClass(SharedDeckId.class)
@Table(name = "share_decks")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class SharedDeck implements Serializable {
    @Id
    @Column(name = "recipient_id")
    private Long recipientId;

    @Id
    @Column(name = "deck_id")
    private Long deckId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id", insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User recipient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id", referencedColumnName = "id", insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Deck deck;

    private Date creation;
}
