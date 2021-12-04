package com.example.fifaprofitapp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String surname;
    private int overall;
    private CardType cardType;

}
