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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String surname;
    private int overall;
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    public Card(String surname, int overall, CardType cardType) {
        this.surname = surname;
        this.overall = overall;
        this.cardType = cardType;
    }
}
