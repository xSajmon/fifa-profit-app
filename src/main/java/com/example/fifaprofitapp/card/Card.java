package com.example.fifaprofitapp.card;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @NotEmpty(message = "Surname cannot be empty.")
    private String surname;
    private int overall;
    @NotNull(message = "Choose your card type.")
    @Enumerated(EnumType.STRING)
    private CardType cardType;

}
