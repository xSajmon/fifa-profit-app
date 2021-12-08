package com.example.fifaprofitapp.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    private int overall;
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    public Card(Long id, String surname, int overall, CardType cardType) {
        this.id = id;
        this.surname = surname;
        this.overall = overall;
        this.cardType = cardType;
    }
}
