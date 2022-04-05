package com.example.fifaprofitapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Deal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Card card;
    private LocalDate saleDate = LocalDate.now();
    @NotNull(message = "Enter buying price.")
    @Positive(message = "Incorrect buying price")
    private int buyingPrice;
    @NotNull(message = "Enter selling price.")
    @Positive(message = "Incorrect selling price")
    private int sellingPrice;
    @Transient
    private double profit;

    public Deal(Long id, Card card, int buyingPrice, int sellingPrice) {
        this.id = id;
        this.card = card;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }

    public double getProfit() {
        return Math.round(sellingPrice * 0.95 - buyingPrice);
    }


}
