package com.example.fifaprofitapp.controllers;


import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.services.DealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/deals/index")
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping
    public String showDeals(Model model, @RequestParam Optional<String> surname){

        List<Deal> list = dealService.getDeals(surname);
        double totalProfit = dealService.calculateTotalProfit(list);

        model.addAttribute("deal", new Deal());
        model.addAttribute("deals", list);
        model.addAttribute("sum", totalProfit);
        model.addAttribute("num", list.size());

        return "deals/index";
    }

    @PostMapping
    public String saveDeal(@ModelAttribute("deal") @Valid Deal deal,
                           BindingResult result,
                           Model model) {
        dealService.saveDeal(deal);
        model.addAttribute("deal", new Deal());
        return "redirect:/deals/index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDeal(@PathVariable Long id){
        dealService.deleteDeal(id);
        return "redirect:/deals/index";
    }




}
