package com.example.fifaprofitapp.controllers;


import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.services.DealService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping("/deals")
    public Collection<Deal> getDeals(){
        return dealService.getDeals();
    }
}
