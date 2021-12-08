package com.example.fifaprofitapp.controllers;


import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.services.DealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/deals/add")
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

    @GetMapping
    public String addDeal(Model model, String surname){
        model.addAttribute("deal", new Deal());
        if (surname == null) {
            model.addAttribute("deals", dealService.getDeals());
        } else {
            model.addAttribute("deals", dealService.findAllByPlayer(surname));
        }
        return "deals/add";
    }


   @PostMapping
    public String saveDeal(@ModelAttribute("deal") Deal deal){
        dealService.saveDeal(deal);
        return "redirect:/deals/add";
   }



}
