package com.example.fifaprofitapp.controllers;


import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.services.DealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping("/deals/json")
    @ResponseBody
    public Collection<Deal> getDealsJson(){
        return dealService.getDeals();
    }


    @GetMapping("/deals")
    public String getDeals(Model model){
        model.addAttribute("deals", dealService.getDeals());
        return "deals/index";
    }
}
