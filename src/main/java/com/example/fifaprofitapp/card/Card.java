package com.example.fifaprofitapp.card;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @NotNull(message = "Surname cannot be null.")
    private String surname;
    private int overall;
    @NotNull(message = "Choose type!")
    @Enumerated(EnumType.STRING)
    private CardType cardType;

}
