package com.example.fifaprofitapp.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Deal {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Card card;
    private LocalDate saleDate;
    private int buyingPrice;
    private int sellingPrice;
    @Transient
    private double profit;

    public Deal(Card card, LocalDate saleDate, int buyingPrice, int sellingPrice) {
        this.card = card;
        this.saleDate = saleDate;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }

    public double getProfit() {
        return sellingPrice  * 0.95 - buyingPrice;
    }
    
}
