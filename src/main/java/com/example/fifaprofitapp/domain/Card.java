package com.example.fifaprofitapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Surname cannot be null.")
    private String surname;
    private int overall;
    @NotNull(message = "Choose type!")
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    public Card(Long id, String surname, int overall, CardType cardType) {
        this.id = id;
        this.surname = surname;
        this.overall = overall;
        this.cardType = cardType;
    }
}
