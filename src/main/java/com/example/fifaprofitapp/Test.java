package com.example.fifaprofitapp;

import com.example.fifaprofitapp.domain.Card;
import com.example.fifaprofitapp.domain.CardType;
import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.services.CardService;
import com.example.fifaprofitapp.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Test implements CommandLineRunner {
    @Autowired
    private DealService dealService;
    @Override
    public void run(String... args) throws Exception {

        Card card = new Card( "Cafu", 88, CardType.IF );
        Card card2 = new Card( "Cafu", 90, CardType.SIF );
        Card card3 = new Card( "Cafuczinio", 90, CardType.SIF );
        Deal deal = new Deal(card, LocalDate.now(), 100, 120);
        Deal deal2 = new Deal(card2, LocalDate.now(), 100, 120);
        dealService.saveDeal(deal);
        dealService.saveDeal(deal2);

        System.out.println(dealService.getDeals());
    }
}
