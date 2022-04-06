package com.example.fifaprofitapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
    private String saleDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yy"));
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
        double x = sellingPrice * 0.95 - buyingPrice;
        BigDecimal vd = new BigDecimal(x).setScale(2, RoundingMode.HALF_UP);
        return vd.doubleValue();

    }




}
