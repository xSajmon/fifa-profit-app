package com.example.fifaprofitapp;

import com.example.fifaprofitapp.domain.Card;
import com.example.fifaprofitapp.domain.CardType;
import com.example.fifaprofitapp.domain.Deal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Test implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        Card card = new Card(1L, "Cafu", 88, CardType.IF );
        Deal deal = new Deal(card, LocalDate.now(), 100, 120);

        System.out.println(card);
        System.out.println(deal);
    }
}
