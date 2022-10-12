package com.example.fifaprofitapp.deal;

import com.example.fifaprofitapp.card.Card;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
@Getter
@Setter
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid
    @Embedded
    private Card card;
    private String saleDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yy"));
    @NotNull(message = "Enter buying price.")
    @Positive(message = "Incorrect buying price.")
    @Digits(integer = 4, fraction = 2)
    private int buyingPrice;
    @NotNull(message = "Enter selling price.")
    private int sellingPrice;
    private boolean completed;
    @Transient
    private double profit;

    public Deal() {
        completed = false;
        sellingPrice = 0;
 }

    public double getProfit() {
        double x = sellingPrice * 0.95 - buyingPrice;
        BigDecimal vd = new BigDecimal(x).setScale(2, RoundingMode.HALF_UP);
        return vd.doubleValue();
    }

}
