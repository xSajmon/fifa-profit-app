package com.example.fifaprofitapp.deal;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class DealDto {

    private String cardName;
    private String cardType;
    private String saleDate;
    private int buyingPrice;
    private int sellingPrice;
    private boolean isCompleted;
    private double profit;

}
